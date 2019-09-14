package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import br.edu.projectdefault.Infrastructure.repository.AcessoRepository;
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
