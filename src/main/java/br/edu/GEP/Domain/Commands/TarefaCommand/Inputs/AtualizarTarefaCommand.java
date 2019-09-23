package br.edu.GEP.Domain.Commands.TarefaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import br.edu.GEP.Domain.Entity.GEP_TAREFA;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Data;

import java.util.Date;

@Data
public class AtualizarTarefaCommand implements BaseCommand
{
    public GEP_TAREFA GEP_TAREFA;
    public GEP_STATUS GEP_STATUS;
    public UsuarioEntity usuarioEntity;
    public String DESCRICAO;
    public Date DT_INICIO_PREV;
    public int DIAS_PREV;
    public Date DT_FIM_PREV;
    public Date DT_INICIO;
    public int DIAS;
    public Date DT_FIM;
    public int RESPONSAVEL;
    public int STATUS_ID;

    @Override
    public void configuration()
    {
        this.GEP_TAREFA.setDESCRICAO(this.DESCRICAO == null ? this.GEP_TAREFA.getDESCRICAO() : this.getDESCRICAO());
        this.GEP_TAREFA.setDT_INICIO_PREV(this.DT_INICIO_PREV == null ? this.GEP_TAREFA.getDT_INICIO_PREV() : this.getDT_INICIO_PREV());
        this.GEP_TAREFA.setDIAS_PREV(this.DIAS_PREV == 0 ? this.GEP_TAREFA.getDIAS_PREV() : this.getDIAS_PREV());
        this.GEP_TAREFA.setDT_FIM_PREV(this.DT_FIM_PREV == null ? this.GEP_TAREFA.getDT_FIM_PREV() : this.getDT_FIM_PREV());
        this.GEP_TAREFA.setDT_INICIO(this.DT_INICIO == null ? this.GEP_TAREFA.getDT_INICIO() : this.getDT_INICIO());
        this.GEP_TAREFA.setDIAS(this.DIAS == 0 ? this.GEP_TAREFA.getDIAS() : this.getDIAS());
        this.GEP_TAREFA.setDT_FIM(this.DT_FIM == null ? this.GEP_TAREFA.getDT_FIM() : this.getDT_FIM());
        this.GEP_TAREFA.setRESPONSAVEL(this.RESPONSAVEL == 0 ? this.GEP_TAREFA.getRESPONSAVEL() : this.getUsuarioEntity());
        this.GEP_TAREFA.setGEP_STATUS(this.STATUS_ID == 0 ? this.GEP_TAREFA.getGEP_STATUS() : this.getGEP_STATUS());
    }
}
