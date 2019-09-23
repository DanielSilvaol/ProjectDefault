package br.edu.GEP.Domain.Commands.SistemaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.SistemaEntity;
import lombok.Data;

@Data
public class DeletarSistemaCommand implements BaseCommand
{
    public SistemaEntity SistemaEntity;
    @Override
    public void configuration()
    {
        this.SistemaEntity.setD_E_L_E_T_("*");
    }
}
