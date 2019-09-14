package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.AtualizarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.DeletarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.SalvarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Outputs.ParametroTO;
import br.edu.projectdefault.Infrastructure.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Service
public class ParametroHandler implements BaseHandler<ParametroTO, SalvarParametroCommand, AtualizarParametroCommand, DeletarParametroCommand>
{
    private final ParametroRepository _repository;

    @Autowired
    public ParametroHandler(ParametroRepository _repository) {this._repository = _repository;}

    @Override
    public List<ParametroTO> Handler()
    {
        return ParametroTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<ParametroTO> Handler(SalvarParametroCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.ParametroEntity);
        URI uri = builder.path("/parametro/{id}").buildAndExpand(command.ParametroEntity.getID()).toUri();
        return ResponseEntity.created(uri).body(new ParametroTO(command.ParametroEntity));
    }

    @Override
    public ResponseEntity<ParametroTO> Handler(Long id, AtualizarParametroCommand command)
    {
        command.ParametroEntity = _repository.getOne(id);
        command.configuration();
        return ResponseEntity.ok(new ParametroTO(command.ParametroEntity));
    }

    @Override
    public ResponseEntity Handler(DeletarParametroCommand command, Long id)
    {
        command.ParametroEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
