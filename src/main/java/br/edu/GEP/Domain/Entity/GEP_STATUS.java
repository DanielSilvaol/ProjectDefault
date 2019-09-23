package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "GEP_STATUS")
public class GEP_STATUS
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ST_ID")
    private Long ST_ID;

    @Column(name = "ST_DESC")
    private String ST_DESC;

    @Column(name = "ST_TIPO")
    private String ST_TIPO;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
