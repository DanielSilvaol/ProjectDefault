package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.projectdefault.Domain.Commands.BaseCommand;
import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import br.edu.projectdefault.Infrastructure.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletarUsuarioCommand implements BaseCommand<UsuarioEntity, UsuarioRepository>
{

    private String D_E_L_E_T_;

    @Override
    public UsuarioEntity Update(Long id, UsuarioRepository _repository)
    {
        UsuarioEntity entity = _repository.getOne(id);
        entity.setD_E_L_E_T_(getD_E_L_E_T_());
        return entity;
    }
}
