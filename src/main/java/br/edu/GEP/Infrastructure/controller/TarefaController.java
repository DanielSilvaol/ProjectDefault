package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.AtualizarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.DeletarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.SalvarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Outputs.TarefaTO;
import br.edu.GEP.Domain.Handler.TarefaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Tarefa")
public class TarefaController implements BaseController<TarefaTO, SalvarTarefaCommand, AtualizarTarefaCommand, DeletarTarefaCommand>
{
    private final TarefaHandler _handler;

    @Autowired
    public TarefaController(TarefaHandler _handler) {this._handler = _handler;}

    @Override
    public List<TarefaTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<TarefaTO> Post(SalvarTarefaCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<TarefaTO> Put(Long id, AtualizarTarefaCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarTarefaCommand command, Long id)
    {
        return _handler.Handler(command, id);
    }
}
