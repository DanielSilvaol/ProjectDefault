package br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.InfoUsuarioEntity;
import lombok.Data;

@Data
public class DeletarInfoUsuarioCommand implements BaseCommand
{
    public InfoUsuarioEntity InfoUsuarioEntity;

    @Override
    public void configuration()
    {
        this.InfoUsuarioEntity.setD_E_L_E_T_("*");
    }
}
