package br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Date;

@Data
public class SalvarProjetoCommand implements BaseCommand
{
    public GEP_PROJETO GEP_PROJETO;
    public int idUser;
    @Override
    public void configuration()
    {
        this.GEP_PROJETO.setDATA_INCLUSAO(new Date());
        this.GEP_PROJETO.setD_E_L_E_T_("");
        this.GEP_PROJETO.setUSUARIO_INCLUSAO(idUser);
    }
}
