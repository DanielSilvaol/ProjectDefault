package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.AtualizarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.DeletarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Inputs.SalvarStatusCommand;
import br.edu.GEP.Domain.Commands.StatusCommand.Outputs.StatusTO;
import br.edu.GEP.Domain.Handler.StatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Status")
public class StatusController implements BaseController<StatusTO, SalvarStatusCommand, AtualizarStatusCommand, DeletarStatusCommand>
{
    private final StatusHandler _handler;

    @Autowired
    public StatusController(StatusHandler _handler) {this._handler = _handler;}

    @Override
    public List<StatusTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<StatusTO> Post(SalvarStatusCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command,builder);
    }

    @Override
    public ResponseEntity<StatusTO> Put(Long id, AtualizarStatusCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarStatusCommand command, Long id)
    {
        return _handler.Handler(command,id);
    }
}
