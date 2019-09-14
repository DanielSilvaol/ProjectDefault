package br.edu.projectdefault.Domain.Commands.InfoUsuarioCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.InfoUsuarioEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class InfoUsuarioTO
{

    public long ID;
    public String NOME;
    public int CPF;
    public String CEP;
    public String RUA;
    public String NUMERO;
    public String COMPLEMENTO;
    public String CIDADE;
    public String ESTADO;
    public double SALARIO;
    public String FUNCAO;

    public InfoUsuarioTO(InfoUsuarioEntity InfoUsuarioEntity)
    {
        this.ID = InfoUsuarioEntity.ID;
        this.NOME = InfoUsuarioEntity.NOME;
        this.CPF = InfoUsuarioEntity.CPF;
        this.CEP = InfoUsuarioEntity.CEP;
        this.RUA = InfoUsuarioEntity.RUA;
        this.NUMERO = InfoUsuarioEntity.NUMERO;
        this.COMPLEMENTO = InfoUsuarioEntity.COMPLEMENTO;
        this.CIDADE = InfoUsuarioEntity.CIDADE;
        this.ESTADO = InfoUsuarioEntity.ESTADO;
        this.SALARIO = InfoUsuarioEntity.SALARIO;
        this.FUNCAO = InfoUsuarioEntity.FUNCAO;
    }


    public static List<InfoUsuarioTO> converter(List<InfoUsuarioEntity> entity)
    {
        return entity.stream().map(InfoUsuarioTO::new).collect(Collectors.toList());
    }
}
