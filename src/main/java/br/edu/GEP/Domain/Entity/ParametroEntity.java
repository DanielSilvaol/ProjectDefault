package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity(name = "PARAMETRO")
public class ParametroEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @Column(name = "NOME")
    private String NOME;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;
}
