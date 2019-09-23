package br.edu.GEP.Domain.Commands.StatusCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import lombok.Data;

@Data
public class DeletarStatusCommand implements BaseCommand
{

    public GEP_STATUS GEP_STATUS;

    @Override
    public void configuration()
    {
        this.GEP_STATUS.setD_E_L_E_T_("*");
    }

}
