package br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.ParametroEntity;
import lombok.Data;

@Data
public class DeletarParametroCommand implements BaseCommand
{
    public ParametroEntity ParametroEntity;
    @Override
    public void configuration()
    {
            this.ParametroEntity.setD_E_L_E_T_("*");
    }
}
