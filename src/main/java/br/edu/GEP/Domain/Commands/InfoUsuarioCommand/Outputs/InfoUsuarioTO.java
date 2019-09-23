package br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Outputs;

import br.edu.GEP.Domain.Entity.InfoUsuarioEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class InfoUsuarioTO
{

    private long ID;
    private String NOME;
    private String CPF;
    private String CEP;
    private String RUA;
    private String NUMERO;
    private String COMPLEMENTO;
    private String CIDADE;
    private String ESTADO;
    private double SALARIO;
    private String FUNCAO;

    public InfoUsuarioTO(InfoUsuarioEntity InfoUsuarioEntity)
    {
        this.ID = InfoUsuarioEntity.getID();
        this.NOME = InfoUsuarioEntity.getNOME();
        this.CPF = InfoUsuarioEntity.getCPF();
        this.CEP = InfoUsuarioEntity.getCEP();
        this.RUA = InfoUsuarioEntity.getRUA();
        this.NUMERO = InfoUsuarioEntity.getNUMERO();
        this.COMPLEMENTO = InfoUsuarioEntity.getCOMPLEMENTO();
        this.CIDADE = InfoUsuarioEntity.getCIDADE();
        this.ESTADO = InfoUsuarioEntity.getESTADO();
        this.SALARIO = InfoUsuarioEntity.getSALARIO();
        this.FUNCAO = InfoUsuarioEntity.getFUNCAO();
    }


    public static List<InfoUsuarioTO> converter(List<InfoUsuarioEntity> entity)
    {
        return entity.stream().map(InfoUsuarioTO::new).collect(Collectors.toList());
    }
}
