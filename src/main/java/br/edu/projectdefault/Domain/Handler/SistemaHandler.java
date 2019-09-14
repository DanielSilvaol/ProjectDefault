package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.SistemaCommand.Inputs.AtualizarSistemaCommand;
import br.edu.projectdefault.Domain.Commands.SistemaCommand.Inputs.DeletarSistemaCommand;
import br.edu.projectdefault.Domain.Commands.SistemaCommand.Inputs.SalvarSistemaCommand;
import br.edu.projectdefault.Domain.Commands.SistemaCommand.Outputs.SistemaTO;
import br.edu.projectdefault.Infrastructure.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class SistemaHandler implements BaseHandler<SistemaTO, SalvarSistemaCommand, AtualizarSistemaCommand, DeletarSistemaCommand>
{
    private final SistemaRepository _repository;

    @Autowired
    public SistemaHandler(SistemaRepository _repository) {this._repository = _repository;}


    @Override
    public List<SistemaTO> Handler()
    {
        return SistemaTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<SistemaTO> Handler(SalvarSistemaCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.SistemaEntity);
        URI uri = builder.path("/sistema/{id}").buildAndExpand(command.SistemaEntity.getID()).toUri();
        return ResponseEntity.created(uri).body(new SistemaTO(command.SistemaEntity));
    }

    @Override
    public ResponseEntity<SistemaTO> Handler(Long id, AtualizarSistemaCommand command)
    {
        command.SistemaEntity = _repository.getOne(id);
        command.configuration();
        return ResponseEntity.ok(new SistemaTO(command.SistemaEntity));
    }

    @Override
    public ResponseEntity Handler(DeletarSistemaCommand command, Long id)
    {
        command.SistemaEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
