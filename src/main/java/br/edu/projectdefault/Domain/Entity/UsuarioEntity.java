package br.edu.projectdefault.Domain.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "USUARIO")
@NoArgsConstructor
public class UsuarioEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long ID;

    @Column(name = "NOME")
    private String NOME ;

    @Column(name = "LOGIN")
    private String LOGIN ;

    @Column(name = "SENHA")
    private String SENHA ;

    @Column(name = "EMAIL")
    private String EMAIL ;

    @Column(name = "BLOQUEADO")
    private boolean BLOQUEADO ;

    @Column(name = "CPF")
    private String CPF ;

    @Column(name = "USUARIO_INCLUSAO")
    private int USUARIO_INCLUSAO ;

    @Column(name = "DATA_INCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date DATA_INCLUSAO ;

    @Column(name = "D_E_L_E_T_")
    private String D_E_L_E_T_;


}
