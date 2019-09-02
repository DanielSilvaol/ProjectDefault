package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import br.edu.projectdefault.Infrastructure.repository.AcessoRepository;
import lombok.Data;

@Data
public class DeletarAcessoCommand implements BaseCommand<AcessoEntity, AcessoRepository>
{
    private String D_E_L_E_T_;

    @Override
    public AcessoEntity Update(Long id, AcessoRepository _repository)
    {
        AcessoEntity entity = _repository.getOne(id);
        entity.setD_E_L_E_T_(D_E_L_E_T_);
        return entity;
    }
}
