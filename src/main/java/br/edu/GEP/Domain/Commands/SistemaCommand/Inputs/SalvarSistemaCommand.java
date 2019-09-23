package br.edu.GEP.Domain.Commands.SistemaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.SistemaEntity;
import lombok.Data;

import java.util.Date;
@Data
public class SalvarSistemaCommand implements BaseCommand
{
    public SistemaEntity SistemaEntity;
    public int idUser;


    @Override
    public void configuration()
    {
        this.SistemaEntity.setDATA_INCLUSAO(new Date());
        this.SistemaEntity.setD_E_L_E_T_("");
        this.SistemaEntity.setUSUARIO_INCLUSAO(idUser);
    }
}
