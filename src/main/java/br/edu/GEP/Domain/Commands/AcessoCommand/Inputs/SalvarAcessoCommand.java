package br.edu.GEP.Domain.Commands.AcessoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.AcessoEntity;
import br.edu.GEP.Domain.Entity.ParametroEntity;
import br.edu.GEP.Domain.Entity.SistemaEntity;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
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
    public int idUserInclusao;


    @Override
    public void configuration()
    {
        this.AcessoEntity = new AcessoEntity();

        this.AcessoEntity.setUser(UsuarioEntity);
        this.AcessoEntity.setSistemaEntity(SistemaEntity);
        this.AcessoEntity.setParametroEntity(ParametroEntity);

        this.AcessoEntity.setDATA_INCLUSAO(new Date());
        this.AcessoEntity.setD_E_L_E_T_("");
        this.AcessoEntity.setUSUARIO_INCLUSAO(idUserInclusao);
    }
}
