package br.edu.projectdefault.Domain.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "GERAL_ACESSO")
@NoArgsConstructor
public class AcessoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long ID;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "TIPO", unique = true)
    public ParametroEntity ParametroEntity;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "ID_USER", unique = true)
    public UsuarioEntity entity;

    @ManyToOne(cascade = CascadeType.REFRESH)
    public SistemaEntity sistemaEntity;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO ;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date DATA_INCLUSAO ;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;


}
