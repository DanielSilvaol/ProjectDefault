package br.edu.projectdefault.Domain.Entity;

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
    public long ID;

    @Column(name = "NOME")
    public String NOME;

    @Column(name = "CPF")
    public int CPF;

    @Column(name = "CEP")
    public String CEP;

    @Column(name = "RUA")
    public String RUA;

    @Column(name = "NUMERO")
    public String NUMERO;

    @Column(name = "COMPLEMENTO")
    public String COMPLEMENTO;

    @Column(name = "CIDADE")
    public String CIDADE;

    @Column(name = "ESTADO")
    public String ESTADO;

    @Column(name = "SALARIO")
    public double SALARIO;

    @Column(name = "FUNCAO")
    public String FUNCAO;

    @Column(name = "USUARIO_INCLUSAO")
    public int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    public Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    public String D_E_L_E_T_;

}
