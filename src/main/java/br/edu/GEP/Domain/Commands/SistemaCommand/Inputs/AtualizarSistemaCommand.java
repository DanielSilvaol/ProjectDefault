package br.edu.GEP.Domain.Commands.SistemaCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.SistemaEntity;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Data;

@Data
public class AtualizarSistemaCommand implements BaseCommand
{
    public SistemaEntity SistemaEntity;
    public String NOME;
    public String SIGLA;
    public UsuarioEntity RESPONSAVEL;

    @Override
    public void configuration()
    {
        this.SistemaEntity.setNOME(this.NOME == null ? this.SistemaEntity.getNOME():this.NOME);
        this.SistemaEntity.setSIGLA(this.SIGLA == null ? this.SistemaEntity.getSIGLA():this.SIGLA);
        this.SistemaEntity.setRESPONSAVEL(this.RESPONSAVEL == null ? this.SistemaEntity.getRESPONSAVEL():this.RESPONSAVEL);
    }
}
