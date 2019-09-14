package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import lombok.Data;

@Data
public class AtualizarAcessoCommand implements BaseCommand
{
    public AcessoEntity AcessoEntity;
    private int id_parametro;

    @Override
    public void configuration()
    {
        this.AcessoEntity.getParametroEntity().setID(id_parametro);
    }
}
