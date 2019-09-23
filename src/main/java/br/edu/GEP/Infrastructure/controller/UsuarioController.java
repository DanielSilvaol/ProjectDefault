package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs.AtualizaUsuarioCommand;
import br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs.DeletarUsuarioCommand;
import br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs.SalvarUsuarioCommand;
import br.edu.GEP.Domain.Commands.UsuarioCommand.Outputs.UsuarioLoginCommand;
import br.edu.GEP.Domain.Commands.UsuarioCommand.Outputs.UsuarioTO;
import br.edu.GEP.Domain.Handler.UsuarioHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Usuario")
public class UsuarioController implements BaseController<UsuarioTO,SalvarUsuarioCommand,AtualizaUsuarioCommand, DeletarUsuarioCommand>
{
    private final UsuarioHandler _handler;

    @Autowired
    public UsuarioController(UsuarioHandler handler)
    {
        _handler = handler;
    }

    @GetMapping
    public List<UsuarioTO> Get()
    {
        return _handler.Handler();
    }

    @PostMapping
    public ResponseEntity<UsuarioTO> Post(@RequestBody SalvarUsuarioCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioTO> Put(@PathVariable Long id, @RequestBody AtualizaUsuarioCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarUsuarioCommand command, Long id)
    {
        return _handler.Handler(command,id);
    }

}
