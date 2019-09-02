package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import br.edu.projectdefault.Infrastructure.repository.AcessoRepository;
import lombok.Data;

@Data
public class AtualizarAcessoCommand implements BaseCommand<AcessoEntity, AcessoRepository>
{
    private String tipo;

    @Override
    public AcessoEntity Update(Long id, AcessoRepository _repository)
    {
        AcessoEntity entity = _repository.getOne(id);
        entity.setTipo(tipo);
        return entity;
    }
}
