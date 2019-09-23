package br.edu.GEP.Domain.Commands.TarefaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_TAREFA;
import lombok.Data;

@Data
public class DeletarTarefaCommand implements BaseCommand
{
    public GEP_TAREFA GEP_TAREFA;
    @Override
    public void configuration()
    {
        this.GEP_TAREFA.setD_E_L_E_T_("*");
    }
}
