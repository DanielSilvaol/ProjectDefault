package br.edu.GEP.Domain.Commands.TarefaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_TAREFA;
import lombok.Data;

import java.util.Date;

@Data
public class SalvarTarefaCommand implements BaseCommand
{
    public GEP_TAREFA GEP_TAREFA;
    public int idUser;
    @Override
    public void configuration()
    {
        this.GEP_TAREFA.setDATA_INCLUSAO(new Date());
        this.GEP_TAREFA.setD_E_L_E_T_("");
        this.GEP_TAREFA.setUSUARIO_INCLUSAO(idUser);
    }
}
