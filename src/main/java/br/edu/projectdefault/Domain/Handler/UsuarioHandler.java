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

@Service
public class UsuarioHandler implements BaseHandler<UsuarioTO, SalvarUsuarioCommand, AtualizaUsuarioCommand, DeletarUsuarioCommand>
{

    private final UsuarioRepository _repository;

    @Autowired
    public UsuarioHandler(UsuarioRepository respository)
    {
        _repository = respository;
    }

    public List<UsuarioTO> Handler()
    {
        List<UsuarioEntity> users = _repository.findAllByD_E_L_E_T_("");
        return UsuarioTO.converter(users);
    }

    public ResponseEntity<UsuarioTO> Handler(SalvarUsuarioCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.UsuarioEntity);
        URI uri = builder.path("/usuario/{id}").buildAndExpand(command.UsuarioEntity.getID()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioTO(command.UsuarioEntity));
    }

    public ResponseEntity<UsuarioTO> Handler(Long id, AtualizaUsuarioCommand command)
    {
        command.UsuarioEntity = _repository.getOne(id);
        command.configuration();
        return ResponseEntity.ok(new UsuarioTO(command.UsuarioEntity));
    }

    @Override
    public ResponseEntity Handler(DeletarUsuarioCommand command, Long id)
    {
        command.UsuarioEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }


}
