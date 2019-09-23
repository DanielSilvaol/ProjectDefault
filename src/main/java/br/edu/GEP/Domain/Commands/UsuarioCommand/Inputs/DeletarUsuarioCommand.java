package br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
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
