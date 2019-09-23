package br.edu.GEP.Domain.Commands.TarefaCommand.Outputs;

import br.edu.GEP.Domain.Entity.GEP_STATUS;
import br.edu.GEP.Domain.Entity.GEP_TAREFA;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TarefaTO
{


    private Long ID;
    private String DESCRICAO;
    private Date DT_INICIO_PREV;
    private int DIAS_PREV;
    private Date DT_FIM_PREV;
    private Date DT_INICIO;
    private int DIAS;
    private Date DT_FIM;
    private String RESPONSAVEL;
    private String STATUS;

    public TarefaTO(GEP_TAREFA GEP_TAREFA)
    {
        this.ID = GEP_TAREFA.getID();
        this.DESCRICAO = GEP_TAREFA.getDESCRICAO();
        this.DT_INICIO_PREV = GEP_TAREFA.getDT_INICIO_PREV();
        this.DIAS_PREV = GEP_TAREFA.getDIAS_PREV();
        this.DT_FIM_PREV = GEP_TAREFA.getDT_FIM_PREV();
        this.DIAS = GEP_TAREFA.getDIAS();
        this.DT_FIM = GEP_TAREFA.getDT_FIM();
        this.RESPONSAVEL = GEP_TAREFA.getRESPONSAVEL().getNOME();
        this.STATUS = GEP_TAREFA.getGEP_STATUS().getST_DESC();
    }

    public static List<TarefaTO> converter(List<GEP_TAREFA> entity)
    {
        return entity.stream().map(TarefaTO::new).collect(Collectors.toList());
    }
}
