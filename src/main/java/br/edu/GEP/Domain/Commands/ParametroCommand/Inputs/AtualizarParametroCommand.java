package br.edu.GEP.Domain.Commands.ParametroCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.ParametroEntity;
import lombok.Data;

@Data
public class AtualizarParametroCommand implements BaseCommand
{
    public ParametroEntity ParametroEntity;
    public String NOME;

    @Override
    public void configuration()
    {
        this.ParametroEntity.setNOME(this.NOME == null ? this.ParametroEntity.getNOME() : this.NOME);
    }
}
