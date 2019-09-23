package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity(name = "GEP_PROJETO")
public class GEP_PROJETO
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NOME")
    private String NOME;

    @Column(name = "SIGLA")
    private String SIGLA;

    @Column(name = "DESCRICAO")
    private String DESCRICAO;

    @Column(name = "OBJETIVO")
    private String OBJETIVO;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
