package br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.InfoUsuarioEntity;
import lombok.Data;

@Data
public class AtualizarInfoUsuarioCommand implements BaseCommand
{
    public InfoUsuarioEntity InfoUsuarioEntity;
    public String CEP;
    public String RUA;
    public String NUMERO;
    public String COMPLEMENTO;
    public String CIDADE;
    public String ESTADO;
    public double SALARIO;
    public String FUNCAO;

    @Override
    public void configuration()
    {
        this.InfoUsuarioEntity.setCEP(this.CEP == null ? this.InfoUsuarioEntity.getCEP():this.CEP);
        this.InfoUsuarioEntity.setRUA(this.RUA == null ? this.InfoUsuarioEntity.getRUA():this.RUA);
        this.InfoUsuarioEntity.setNUMERO(this.NUMERO == null ? this.InfoUsuarioEntity.getNUMERO():this.NUMERO);
        this.InfoUsuarioEntity.setCOMPLEMENTO(this.COMPLEMENTO == null ? this.InfoUsuarioEntity.getCOMPLEMENTO():this.COMPLEMENTO);
        this.InfoUsuarioEntity.setCIDADE(this.CIDADE == null ? this.InfoUsuarioEntity.getCIDADE():this.CIDADE);
        this.InfoUsuarioEntity.setESTADO(this.ESTADO == null ? this.InfoUsuarioEntity.getESTADO():this.ESTADO);
        this.InfoUsuarioEntity.setSALARIO(this.SALARIO == 0 ? this.InfoUsuarioEntity.getSALARIO():this.SALARIO);
        this.InfoUsuarioEntity.setFUNCAO(this.FUNCAO == null ? this.InfoUsuarioEntity.getFUNCAO():this.FUNCAO);
    }
}
