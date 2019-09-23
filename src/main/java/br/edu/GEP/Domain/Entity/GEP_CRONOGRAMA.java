package br.edu.GEP.Domain.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "GEP_CRONOGRAMA")
public class GEP_CRONOGRAMA
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PROJ_ID",foreignKey = @ForeignKey(name = "FK_PROJETO_CRONOGRAMA"))
    private GEP_PROJETO GEP_PROJETO;

    @Column(name = "NOME")
    private String NOME;

    @Column(name = "ORIGEM")
    private String ORIGEM;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "LIDER",foreignKey = @ForeignKey(name = "FK_LIDER_CRONOGRAMA"))
    private UsuarioEntity LIDER;

    @Column(name = "DESCRICAO")
    private String DESCRICAO;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "STATUS_ID",foreignKey = @ForeignKey(name = "FK_STATUS_CRONOGRAMA"))
    private GEP_STATUS GEP_STATUS;

    @Column(name = "DT_INICIO_PREV")
    private Date DT_INICIO_PREV;

    @Column(name = "DT_FIM_PREV")
    private Date DT_FIM_PREV;

    @Column(name = "DIAS_PREV")
    private int DIAS_PREV;

    @Column(name = "DT_INICIO")
    private Date DT_INICIO;

    @Column(name = "DT_FIM")
    private Date DT_FIM;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    private Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;

}
