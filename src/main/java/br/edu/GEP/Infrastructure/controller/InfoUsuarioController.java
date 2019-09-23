package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.AtualizarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.DeletarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.SalvarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Outputs.InfoUsuarioTO;
import br.edu.GEP.Domain.Handler.InfoUsuarioHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("InfoUsuario")
public class InfoUsuarioController implements BaseController<InfoUsuarioTO, SalvarInfoUsuarioCommand, AtualizarInfoUsuarioCommand, DeletarInfoUsuarioCommand>
{
    private final InfoUsuarioHandler _handler;

    @Autowired
    public InfoUsuarioController(InfoUsuarioHandler _handler) {this._handler = _handler;}

    @Override
    public List<InfoUsuarioTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<InfoUsuarioTO> Post(SalvarInfoUsuarioCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<InfoUsuarioTO> Put(Long id, AtualizarInfoUsuarioCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarInfoUsuarioCommand command, Long id)
    {
        return _handler.Handler(command, id);
    }
}
