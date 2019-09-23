package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.AtualizarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.DeletarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Inputs.SalvarTarefaCommand;
import br.edu.GEP.Domain.Commands.TarefaCommand.Outputs.TarefaTO;
import br.edu.GEP.Infrastructure.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class TarefaHandler implements BaseHandler<TarefaTO, SalvarTarefaCommand, AtualizarTarefaCommand,DeletarTarefaCommand>
{
    private final TarefaRepository _repository;

    @Autowired
    public TarefaHandler(TarefaRepository _repository) {this._repository = _repository;}

    @Override
    public List<TarefaTO> Handler()
    {
        return TarefaTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<TarefaTO> Handler(SalvarTarefaCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.GEP_TAREFA);
        URI uri = builder.path("/tarefa/{id}").buildAndExpand(command.GEP_TAREFA.getID()).toUri();
        return ResponseEntity.created(uri).body(new TarefaTO(command.GEP_TAREFA));
    }

    @Override
    public ResponseEntity<TarefaTO> Handler(Long id, AtualizarTarefaCommand command)
    {
        command.GEP_TAREFA = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok(new TarefaTO(command.GEP_TAREFA));
    }

    @Override
    public ResponseEntity Handler(DeletarTarefaCommand command, Long id)
    {
        command.GEP_TAREFA = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
