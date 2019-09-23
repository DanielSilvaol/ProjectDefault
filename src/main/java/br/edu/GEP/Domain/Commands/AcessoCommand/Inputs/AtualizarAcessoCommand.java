package br.edu.GEP.Domain.Commands.AcessoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.AcessoEntity;
import br.edu.GEP.Domain.Entity.ParametroEntity;
import lombok.Data;

@Data
public class AtualizarAcessoCommand implements BaseCommand
{
    public AcessoEntity AcessoEntity;
    public ParametroEntity parametro;

    @Override
    public void configuration()
    {
        this.AcessoEntity.setParametroEntity(parametro);
    }
}
