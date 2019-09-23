package br.edu.GEP.Domain.Commands.DefaultCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Data;

@Data
public class DeletarDefaultCommand implements BaseCommand
{

//    public ENTITY ENTITY;

    @Override
    public void configuration()
    {
//        this.ENTITY.setD_E_L_E_T_("*");
    }

}
