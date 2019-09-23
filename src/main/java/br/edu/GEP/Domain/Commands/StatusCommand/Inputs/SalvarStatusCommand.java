package br.edu.GEP.Domain.Commands.StatusCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import lombok.Data;

import java.util.Date;

@Data
public class SalvarStatusCommand implements BaseCommand
{
    public GEP_STATUS GEP_STATUS;
    public int idUser;

    @Override
    public void configuration()
    {
        this.GEP_STATUS.setDATA_INCLUSAO(new Date());
        this.GEP_STATUS.setD_E_L_E_T_("");
        this.GEP_STATUS.setUSUARIO_INCLUSAO(idUser);
    }
}
