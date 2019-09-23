package br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_CRONOGRAMA;
import lombok.Data;

import java.util.Date;

@Data
public class SalvarCronogramaCommand implements BaseCommand
{
    public GEP_CRONOGRAMA GEP_CRONOGRAMA;
    public int idUser;
    @Override
    public void configuration()
    {
        this.GEP_CRONOGRAMA.setDATA_INCLUSAO(new Date());
        this.GEP_CRONOGRAMA.setD_E_L_E_T_("");
        this.GEP_CRONOGRAMA.setUSUARIO_INCLUSAO(idUser);
    }
}
