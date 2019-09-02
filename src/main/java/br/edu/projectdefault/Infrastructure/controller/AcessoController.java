package br.edu.projectdefault.Infrastructure.controller;

import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.AtualizarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.DeletarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.SalvarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Outputs.AcessoTO;
import br.edu.projectdefault.Domain.Handler.AcessoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/Acesso")
public class AcessoController implements BaseController<AcessoTO,SalvarAcessoCommand, AtualizarAcessoCommand, DeletarAcessoCommand>
{
    private final AcessoHandler _handler;

    @Autowired
    public AcessoController(AcessoHandler _handler) {this._handler = _handler;}

    @GetMapping
    public List<AcessoTO> Get()
    {
        return _handler.Handler();
    }

    @PostMapping
    public ResponseEntity<AcessoTO> Post(@RequestBody SalvarAcessoCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    public ResponseEntity<AcessoTO> Put(Long id, AtualizarAcessoCommand command)
    {
        return _handler.Handler(id,command);
    }


    public ResponseEntity Delete(DeletarAcessoCommand command,Long id)
    {
        return _handler.Handler(command,id);
    }

}
