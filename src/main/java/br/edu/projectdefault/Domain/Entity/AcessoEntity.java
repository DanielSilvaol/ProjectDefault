package br.edu.projectdefault.Domain.Entity;

import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.SalvarAcessoCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "GERAL_ACESSO")
@NoArgsConstructor
public class AcessoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long id;

    @Column(name = "TIPO")
    public String tipo;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "USER_ID", unique = true)
    public UsuarioEntity entity;

    @Column(name = "D_E_L_E_T_")
    public String D_E_L_E_T_;

    public AcessoEntity(SalvarAcessoCommand command)
    {
        this.tipo = command.tipo;
        this.entity = command.entity;
    }
}
