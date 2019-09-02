package br.edu.projectdefault.Domain.Commands.AcessoCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AcessoTO
{
    public String user_name;
    public String tipo;

    public AcessoTO(AcessoEntity entity)
    {
        this.user_name = entity.entity.getName();
        this.tipo = entity.tipo;
    }

    public static List<AcessoTO> converter(List<AcessoEntity> entity)
    {
        return entity.stream().map(AcessoTO::new).collect(Collectors.toList());
    }
}
