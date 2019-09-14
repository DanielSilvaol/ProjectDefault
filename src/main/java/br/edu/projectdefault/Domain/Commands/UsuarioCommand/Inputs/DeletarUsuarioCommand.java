package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletarUsuarioCommand implements BaseCommand
{
    public UsuarioEntity UsuarioEntity;

    @Override
    public void configuration()
    {
        this.UsuarioEntity.setD_E_L_E_T_("*");
    }
}
