package br.edu.GEP.Domain.Commands.SistemaCommand.Outputs;

import br.edu.GEP.Domain.Entity.SistemaEntity;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class SistemaTO
{
    private Long ID;
    private String NOME;
    private String SIGLA;
    private String RESPONSAVEL;

    public SistemaTO(SistemaEntity SistemaEntity)
    {
        this.ID = SistemaEntity.getID();
        this.NOME = SistemaEntity.getNOME();
        this.SIGLA = SistemaEntity.getSIGLA();
        this.RESPONSAVEL = SistemaEntity.getRESPONSAVEL().getNOME();
    }

    public static List<SistemaTO> converter(List<SistemaEntity> entity)
    {
        return entity.stream().map(SistemaTO::new).collect(Collectors.toList());
    }
}
