package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.AtualizarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.DeletarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Inputs.SalvarParametroCommand;
import br.edu.projectdefault.Domain.Commands.ParametroCommand.Outputs.ParametroTO;
import br.edu.projectdefault.Domain.Handler.ParametroHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Parametro")
public class ParametroController implements BaseController<ParametroTO, SalvarParametroCommand, AtualizarParametroCommand, DeletarParametroCommand>
{
    private final ParametroHandler _handler;

    @Autowired
    public ParametroController(ParametroHandler _handler) {this._handler = _handler;}

    @Override
    public List<ParametroTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<ParametroTO> Post(SalvarParametroCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<ParametroTO> Put(Long id, AtualizarParametroCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarParametroCommand command, Long id)
    {
        return _handler.Handler(command,id);
    }
}
