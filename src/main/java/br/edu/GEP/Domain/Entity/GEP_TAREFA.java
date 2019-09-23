package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "GEP_TAREFA")
public class GEP_TAREFA
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "CRONO_ID",foreignKey = @ForeignKey(name = "FK_CRONOGRAMA_TAREFA"))
    private GEP_CRONOGRAMA GEP_CRONOGRAMA;

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "PROJ_ID",foreignKey = @ForeignKey(name = "FK_PROJETO_TAREFA"))
    private GEP_PROJETO GEP_PROJETO;

    @Column(name = "DESCRICAO")
    private String DESCRICAO;

    @Column(name = "DT_INICIO_PREV")
    private Date DT_INICIO_PREV;

    @Column(name = "DIAS_PREV")
    private int DIAS_PREV;

    @Column(name = "DT_FIM_PREV")
    private Date DT_FIM_PREV;

    @Column(name = "DT_INICIO")
    private Date DT_INICIO;

    @Column(name = "DIAS")
    private int DIAS;

    @Column(name = "DT_FIM")
    private Date DT_FIM;

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "RESPONSAVEL",foreignKey = @ForeignKey(name = "FK_RESPONSAVEL_TAREFA"))
    private UsuarioEntity RESPONSAVEL;

    @ManyToOne(cascade =  CascadeType.REFRESH)
    @JoinColumn(name = "STATUS_ID",foreignKey = @ForeignKey(name = "FK_STATUS_TAREFA"))
    private GEP_STATUS GEP_STATUS;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
