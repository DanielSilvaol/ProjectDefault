package br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import lombok.Data;

@Data
public class DeletarProjetoCommand implements BaseCommand
{
    public GEP_PROJETO GEP_PROJETO;
    @Override
    public void configuration()
    {
        this.GEP_PROJETO.setD_E_L_E_T_("*");
    }
}
