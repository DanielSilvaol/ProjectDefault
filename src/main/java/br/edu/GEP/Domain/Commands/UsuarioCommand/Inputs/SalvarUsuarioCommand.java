package br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalvarUsuarioCommand implements BaseCommand
{

    public UsuarioEntity UsuarioEntity;
    public int idUser;


    public void configuration()
    {
        this.UsuarioEntity.setBLOQUEADO(false);
        this.UsuarioEntity.setDATA_INCLUSAO(new Date());
        this.UsuarioEntity.setD_E_L_E_T_("");
        this.UsuarioEntity.setUSUARIO_INCLUSAO(idUser);
    }

}
