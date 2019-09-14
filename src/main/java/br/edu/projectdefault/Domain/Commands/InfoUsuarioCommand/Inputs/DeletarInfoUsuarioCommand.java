package br.edu.projectdefault.Domain.Commands.InfoUsuarioCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.InfoUsuarioEntity;
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
