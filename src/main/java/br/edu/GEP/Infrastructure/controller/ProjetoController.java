package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.AtualizarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.DeletarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.SalvarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Outputs.ProjetoTO;
import br.edu.GEP.Domain.Handler.ProjetoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Projeto")
public class ProjetoController implements BaseController<ProjetoTO, SalvarProjetoCommand, AtualizarProjetoCommand, DeletarProjetoCommand>
{
    private final ProjetoHandler _handler;

    @Autowired
    public ProjetoController(ProjetoHandler _handler) {this._handler = _handler;}

    @Override
    public List<ProjetoTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<ProjetoTO> Post(SalvarProjetoCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<ProjetoTO> Put(Long id, AtualizarProjetoCommand command)
    {
        return _handler.Handler(id,command);
    }

    @Override
    public ResponseEntity Delete(DeletarProjetoCommand command, Long id)
    {
        return _handler.Handler(command,id);
    }
}
