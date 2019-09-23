package br.edu.GEP.Domain.Commands.CronogramaCommand.Outputs;

import br.edu.GEP.Domain.Entity.GEP_CRONOGRAMA;
import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CronogramaTO
{
    private Long ID;
    private String PROJETO;
    private String NOME;
    private String ORIGEM;
    private String LIDER;
    private String DESCRICAO;
    private String STATUS;
    private Date DT_INICIO_PREV;
    private Date DT_FIM_PREV;
    private int DIAS_PREV;
    private Date DT_INICIO;
    private Date DT_FIM;

    public CronogramaTO(GEP_CRONOGRAMA GEP_CRONOGRAMA)
    {
        this.ID = GEP_CRONOGRAMA.getID();
        this.PROJETO = GEP_CRONOGRAMA.getGEP_PROJETO().getNOME();
        this.NOME = GEP_CRONOGRAMA.getNOME();
        this.ORIGEM = GEP_CRONOGRAMA.getORIGEM();
        this.LIDER = GEP_CRONOGRAMA.getLIDER().getNOME();
        this.DESCRICAO = GEP_CRONOGRAMA.getDESCRICAO();
        this.STATUS = GEP_CRONOGRAMA.getGEP_STATUS().getST_DESC();
        this.DT_INICIO_PREV = GEP_CRONOGRAMA.getDT_INICIO_PREV();
        this.DT_FIM_PREV = GEP_CRONOGRAMA.getDT_FIM_PREV();
        this.DIAS_PREV = GEP_CRONOGRAMA.getDIAS_PREV();
        this.DT_INICIO = GEP_CRONOGRAMA.getDT_INICIO();
        this.DT_FIM = GEP_CRONOGRAMA.getDT_FIM();
    }

    public static List<CronogramaTO> converter(List<GEP_CRONOGRAMA> entity)
    {
        return entity.stream().map(CronogramaTO::new).collect(Collectors.toList());
    }
}
