package br.edu.GEP.Domain.Commands.ParametroCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.ParametroEntity;
import lombok.Data;

import java.util.Date;
@Data
public class SalvarParametroCommand implements BaseCommand
{
    public ParametroEntity ParametroEntity;
    public int idUser;

    @Override
    public void configuration()
    {
        this.ParametroEntity.setDATA_INCLUSAO(new Date());
        this.ParametroEntity.setD_E_L_E_T_("");
        this.ParametroEntity.setUSUARIO_INCLUSAO(idUser);
    }
}
