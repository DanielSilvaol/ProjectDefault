package br.edu.GEP.Domain.Commands.StatusCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import lombok.Data;

@Data
public class AtualizarStatusCommand implements BaseCommand
{
    public GEP_STATUS GEP_STATUS;
    public String ST_DESC;
    public String ST_TIPO;

    @Override
    public void configuration()
    {
        this.GEP_STATUS.setST_DESC(this.ST_DESC == null ? this.GEP_STATUS.getST_DESC():this.getST_DESC());
        this.GEP_STATUS.setST_TIPO(this.ST_TIPO == null ? this.GEP_STATUS.getST_TIPO():this.getST_TIPO());
    }
}
