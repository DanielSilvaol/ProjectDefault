package br.edu.projectdefault.Domain.Commands.SistemaCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.SistemaEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SistemaTO
{
    public int ID;
    public String NOME;
    public String SIGLA;
    public int RESPONSAVEL;

    public SistemaTO(SistemaEntity SistemaEntity)
    {
        this.ID = SistemaEntity.ID;
        this.NOME = SistemaEntity.NOME;
        this.SIGLA = SistemaEntity.SIGLA;
        this.RESPONSAVEL = SistemaEntity.RESPONSAVEL;
    }

    public static List<SistemaTO> converter(List<SistemaEntity> entity)
    {
        return entity.stream().map(SistemaTO::new).collect(Collectors.toList());
    }
}
