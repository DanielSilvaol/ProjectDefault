package br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_CRONOGRAMA;
import lombok.Data;

@Data
public class DeletarCronogramaCommand implements BaseCommand
{
    public GEP_CRONOGRAMA GEP_CRONOGRAMA;

    @Override
    public void configuration()
    {
        this.GEP_CRONOGRAMA.setD_E_L_E_T_("*");
    }
}
