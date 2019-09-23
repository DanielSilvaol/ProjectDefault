package br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_CRONOGRAMA;
import br.edu.GEP.Domain.Entity.GEP_STATUS;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Data;

import java.util.Date;

@Data
public class AtualizarCronogramaCommand implements BaseCommand
{
    public GEP_CRONOGRAMA GEP_CRONOGRAMA;
    public GEP_STATUS GEP_STATUS;
    public UsuarioEntity liderUser;
    private String NOME;
    public String ORIGEM;
    public String DESCRICAO;
    public Date DT_INICIO_PREV;
    public Date DT_FIM_PREV;
    public Date DT_INICIO;
    public Date DT_FIM;

    @Override
    public void configuration()
    {
        this.GEP_CRONOGRAMA.setNOME(this.NOME == null ? this.GEP_CRONOGRAMA.getNOME() : this.NOME);
        this.GEP_CRONOGRAMA.setORIGEM(this.ORIGEM == null ? this.GEP_CRONOGRAMA.getORIGEM() : this.ORIGEM);
        this.GEP_CRONOGRAMA.setLIDER(this.liderUser == null ? this.GEP_CRONOGRAMA.getLIDER() : this.liderUser);
        this.GEP_CRONOGRAMA.setDESCRICAO(this.DESCRICAO == null ? this.GEP_CRONOGRAMA.getDESCRICAO() : this.DESCRICAO);
        this.GEP_CRONOGRAMA.setGEP_STATUS(this.GEP_STATUS == null ? this.GEP_CRONOGRAMA.getGEP_STATUS() : this.GEP_STATUS);
        this.GEP_CRONOGRAMA.setDT_INICIO_PREV(this.DT_INICIO_PREV == null ? this.GEP_CRONOGRAMA.getDT_INICIO_PREV() : this.DT_INICIO_PREV);
        this.GEP_CRONOGRAMA.setDT_FIM_PREV(this.DT_FIM_PREV == null ? this.GEP_CRONOGRAMA.getDT_FIM_PREV() : this.DT_FIM_PREV);
        this.GEP_CRONOGRAMA.setDT_INICIO(this.DT_INICIO == null ? this.GEP_CRONOGRAMA.getDT_INICIO() : this.DT_INICIO);
        this.GEP_CRONOGRAMA.setDT_FIM(this.DT_FIM == null ? this.GEP_CRONOGRAMA.getDT_FIM() : this.DT_FIM);
    }
}
