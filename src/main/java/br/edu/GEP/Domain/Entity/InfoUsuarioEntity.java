package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "INFO_USUARIO")
public class InfoUsuarioEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID;

    @Column(name = "NOME")
    private String NOME;

    @Column(name = "CPF")
    private String CPF;

    @Column(name = "CEP")
    private String CEP;

    @Column(name = "RUA")
    private String RUA;

    @Column(name = "NUMERO")
    private String NUMERO;

    @Column(name = "COMPLEMENTO")
    private String COMPLEMENTO;

    @Column(name = "CIDADE")
    private String CIDADE;

    @Column(name = "ESTADO")
    private String ESTADO;

    @Column(name = "SALARIO")
    private double SALARIO;

    @Column(name = "FUNCAO")
    private String FUNCAO;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
