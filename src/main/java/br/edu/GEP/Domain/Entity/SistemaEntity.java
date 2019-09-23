package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "SISTEMA")
public class SistemaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NOME")
    private String NOME;

    @Column(name = "SIGLA")
    private String SIGLA;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "RESPONSAVEL",foreignKey = @ForeignKey(name = "FK_RESPONSAVEL_SISTEMA"))
    private UsuarioEntity RESPONSAVEL;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
