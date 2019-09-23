package br.edu.GEP.Domain.Commands.AcessoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.AcessoEntity;
import lombok.Data;

@Data
public class DeletarAcessoCommand implements BaseCommand
{
    public AcessoEntity AcessoEntity;

    @Override
    public void configuration()
    {
        this.AcessoEntity.setD_E_L_E_T_("*");
    }
}
