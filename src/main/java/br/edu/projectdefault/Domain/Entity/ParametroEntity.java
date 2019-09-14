package br.edu.projectdefault.Domain.Entity;

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
    public int ID;

    @Column(name = "NOME")
    public String NOME;

    @Column(name = "USUARIO_INCLUSAO")
    public int USUARIO_INCLUSAO;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    public Date DATA_INCLUSAO;

    @Column(name = "D_E_L_E_T_")
    public String D_E_L_E_T_;
}
