package br.edu.GEP.Domain.Commands.AcessoCommand.Outputs;

import br.edu.GEP.Domain.Entity.AcessoEntity;
import br.edu.GEP.Domain.Entity.ParametroEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AcessoTO
{
    private long ID;
    private String NOME;
    private String PARAMETRO;
    private String SISTEMA;


    public AcessoTO(AcessoEntity entity)
    {
        this.ID = entity.getID();
        this.NOME = entity.getUser().getNOME();
        this.PARAMETRO = entity.getParametroEntity().getNOME();
        this.SISTEMA = entity.getSistemaEntity().getNOME();
    }

    public static List<AcessoTO> converter(List<AcessoEntity> entity)
    {
        return entity.stream().map(AcessoTO::new).collect(Collectors.toList());
    }
}
