package br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import lombok.Data;

@Data
public class AtualizarProjetoCommand implements BaseCommand
{
    public GEP_PROJETO GEP_PROJETO;
    public String NOME;
    public String SIGLA;
    public String DESCRICAO;
    public String OBJETIVO;

    @Override
    public void configuration()
    {
        this.GEP_PROJETO.setNOME(this.NOME == null ? this.GEP_PROJETO.getNOME() : this.getNOME());
        this.GEP_PROJETO.setSIGLA(this.SIGLA == null ? this.GEP_PROJETO.getSIGLA() : this.getSIGLA());
        this.GEP_PROJETO.setDESCRICAO(this.DESCRICAO == null ? this.GEP_PROJETO.getNOME() : this.getDESCRICAO());
        this.GEP_PROJETO.setOBJETIVO(this.OBJETIVO == null ? this.GEP_PROJETO.getOBJETIVO() : this.getOBJETIVO());
    }
}
