package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.AtualizaUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.DeletarUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Inputs.SalvarUsuarioCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs.UsuarioLoginCommand;
import br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs.UsuarioTO;
import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import br.edu.projectdefault.Infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioHandler implements BaseHandler<UsuarioTO, SalvarUsuarioCommand, AtualizaUsuarioCommand, DeletarUsuarioCommand>
{

    private final UsuarioRepository _respository;

    @Autowired
    public UsuarioHandler(UsuarioRepository respository)
    {
        _respository = respository;
    }

    public List<UsuarioTO> Handler()
    {
        List<UsuarioEntity> users = _respository.findAllByD_E_L_E_T_("");
        return UsuarioTO.converter(users);
    }

    public ResponseEntity<UsuarioTO> Handler(SalvarUsuarioCommand command, UriComponentsBuilder builder)
    {
        UsuarioEntity entity = new UsuarioEntity(command);
        entity.setD_E_L_E_T_("");
        _respository.save(entity);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioTO(entity));
    }

    public ResponseEntity<UsuarioTO> Handler(Long id, AtualizaUsuarioCommand command)
    {
        UsuarioEntity entity = command.Update(id, _respository);
        return ResponseEntity.ok(new UsuarioTO(entity));
    }

    @Override
    public ResponseEntity Handler(DeletarUsuarioCommand command, Long id)
    {
        command.setD_E_L_E_T_("*");
        command.Update(id, _respository);
        return ResponseEntity.ok().build();
    }


    public boolean Handler(UsuarioLoginCommand command)
    {
        return _respository.existsByUsernameAndPassword(command.getUsername(), command.getPassword());
    }

}
