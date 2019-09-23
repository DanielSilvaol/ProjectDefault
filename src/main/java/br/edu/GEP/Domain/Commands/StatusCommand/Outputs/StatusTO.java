package br.edu.GEP.Domain.Commands.StatusCommand.Outputs;

import br.edu.GEP.Domain.Entity.GEP_STATUS;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class StatusTO
{
    private Long ST_ID;
    private String ST_DESC;
    private String ST_TIPO;

    public StatusTO(GEP_STATUS GEP_STATUS)
    {
        this.ST_ID = GEP_STATUS.getST_ID();
        this.ST_DESC = GEP_STATUS.getST_DESC();
        this.ST_TIPO = GEP_STATUS.getST_TIPO();
    }

    public static List<StatusTO> converter(List<GEP_STATUS> entity)
    {
        return entity.stream().map(StatusTO::new).collect(Collectors.toList());
    }
}
