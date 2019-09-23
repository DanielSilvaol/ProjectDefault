package br.edu.GEP.Domain.Commands.DefaultCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_CRONOGRAMA;
import lombok.Data;

import java.util.Date;

@Data
public class SalvarDefaultCommand implements BaseCommand
{
    //public ENTITY ENTITY;
    public int idUser;

    @Override
    public void configuration()
    {
//        this.ENTITY.setDATA_INCLUSAO(new Date());
//        this.ENTITY.setD_E_L_E_T_("");
//        this.ENTITY.setUSUARIO_INCLUSAO(idUser);
    }
}
