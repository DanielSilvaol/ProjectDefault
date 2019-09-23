package br.edu.GEP.Domain.Commands.ProjetoCommand.Outputs;

import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProjetoTO
{
    private Long ID;
    private String NOME;
    private String SIGLA;
    private String DESCRICAO;
    private String OBJETIVO;

    public ProjetoTO(GEP_PROJETO GEP_PROJETO)
    {
        this.ID = GEP_PROJETO.getID();
        this.NOME = GEP_PROJETO.getNOME();
        this.SIGLA = GEP_PROJETO.getSIGLA();
        this.DESCRICAO = GEP_PROJETO.getDESCRICAO();
        this.OBJETIVO = GEP_PROJETO.getOBJETIVO();
    }

    public static List<ProjetoTO> converter(List<GEP_PROJETO> entity)
    {
        return entity.stream().map(ProjetoTO::new).collect(Collectors.toList());
    }
}
