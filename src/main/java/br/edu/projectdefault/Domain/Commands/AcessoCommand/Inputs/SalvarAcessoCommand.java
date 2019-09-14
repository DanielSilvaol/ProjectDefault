package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import br.edu.projectdefault.Domain.Entity.ParametroEntity;
import br.edu.projectdefault.Domain.Entity.SistemaEntity;
import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalvarAcessoCommand implements BaseCommand
{
    public AcessoEntity AcessoEntity;
    public UsuarioEntity UsuarioEntity;
    public SistemaEntity SistemaEntity;
    public ParametroEntity ParametroEntity;
    public long parametro;
    public long sistema;
    public long user;
    public int idUserInclusao;


    @Override
    public void configuration()
    {
        this.AcessoEntity.setParametroEntity(ParametroEntity);
        this.AcessoEntity.setEntity(UsuarioEntity);
        this.AcessoEntity.setSistemaEntity(SistemaEntity);

        this.UsuarioEntity.setDATA_INCLUSAO(new Date());
        this.UsuarioEntity.setD_E_L_E_T_("");
        this.UsuarioEntity.setUSUARIO_INCLUSAO(idUserInclusao);
    }
}
