package br.edu.projectdefault.Domain.Commands.ParametroCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.ParametroEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class ParametroTO
{

    public int ID;
    public String NOME;

    public ParametroTO(ParametroEntity ParametroEntity)
    {
        this.ID = ParametroEntity.getID();
        this.NOME = ParametroEntity.getNOME();
    }

    public static List<ParametroTO> converter(List<ParametroEntity> entity)
    {
        return entity.stream().map(ParametroTO::new).collect(Collectors.toList());
    }
}
