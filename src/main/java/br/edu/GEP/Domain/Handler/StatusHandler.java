package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.AtualizarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.DeletarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.SalvarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Outputs.StatusTO;
import br.edu.GEP.Infrastructure.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class StatusHandler implements BaseHandler<StatusTO, SalvarStatusCommand, AtualizarStatusCommand, DeletarStatusCommand>
{
    private final StatusRepository _repository;

    @Autowired
    public StatusHandler(StatusRepository _repository) {this._repository = _repository;}

    @Override
    public List<StatusTO> Handler()
    {
        return StatusTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<StatusTO> Handler(SalvarStatusCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.GEP_STATUS);
        URI uri = builder.path("/status/{id}").buildAndExpand(command.GEP_STATUS.getST_ID()).toUri();
        return ResponseEntity.created(uri).body(new StatusTO(command.GEP_STATUS));
    }

    @Override
    public ResponseEntity<StatusTO> Handler(Long id, AtualizarStatusCommand command)
    {
        command.GEP_STATUS = _repository.getOne(id);
        command.configuration();
        return ResponseEntity.ok(new StatusTO(command.GEP_STATUS));
    }

    @Override
    public ResponseEntity Handler(DeletarStatusCommand command, Long id)
    {
        command.GEP_STATUS = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
