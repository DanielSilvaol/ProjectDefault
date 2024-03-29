package br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.InfoUsuarioEntity;
import lombok.Data;

import java.util.Date;

@Data
public class SalvarInfoUsuarioCommand implements BaseCommand
{
    public InfoUsuarioEntity InfoUsuarioEntity;
    public int idUser;

    @Override
    public void configuration()
    {
        this.InfoUsuarioEntity.setDATA_INCLUSAO(new Date());
        this.InfoUsuarioEntity.setD_E_L_E_T_("");
        this.InfoUsuarioEntity.setUSUARIO_INCLUSAO(idUser);
    }
}
