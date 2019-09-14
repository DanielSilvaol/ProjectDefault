package br.edu.projectdefault.Domain.Commands.AcessoCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AcessoTO
{
    public long ID;
    public String user_name;
    public int parametro_id;
    public long SISTEMA;


    public AcessoTO(AcessoEntity entity)
    {
        this.ID = entity.ID;
        this.user_name = entity.entity.getNOME();
        this.parametro_id = entity.ParametroEntity.getID();
        this.SISTEMA = entity.getSistemaEntity().getID();
    }

    public static List<AcessoTO> converter(List<AcessoEntity> entity)
    {
        return entity.stream().map(AcessoTO::new).collect(Collectors.toList());
    }
}
