package br.edu.projectdefault.Domain.Commands.SistemaCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.SistemaEntity;
import lombok.Data;

@Data
public class AtualizarSistemaCommand implements BaseCommand
{
    public SistemaEntity SistemaEntity;
    public String NOME;
    public String SIGLA;
    public int RESPONSAVEL;

    @Override
    public void configuration()
    {
        this.SistemaEntity.setNOME(this.NOME == null ? this.SistemaEntity.getNOME():this.NOME);
        this.SistemaEntity.setSIGLA(this.SIGLA == null ? this.SistemaEntity.getSIGLA():this.SIGLA);
        this.SistemaEntity.setRESPONSAVEL(this.RESPONSAVEL == 0 ? this.SistemaEntity.getRESPONSAVEL():this.RESPONSAVEL);
    }
}
