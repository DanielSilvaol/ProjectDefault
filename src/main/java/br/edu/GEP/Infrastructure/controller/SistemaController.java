package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.SistemaCommand.Inputs.AtualizarSistemaCommand;
import br.edu.GEP.Domain.Commands.SistemaCommand.Inputs.DeletarSistemaCommand;
import br.edu.GEP.Domain.Commands.SistemaCommand.Inputs.SalvarSistemaCommand;
import br.edu.GEP.Domain.Commands.SistemaCommand.Outputs.SistemaTO;
import br.edu.GEP.Domain.Handler.SistemaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Sistema")
public class SistemaController implements BaseController<SistemaTO, SalvarSistemaCommand, AtualizarSistemaCommand, DeletarSistemaCommand>
{
    private final SistemaHandler _handler;

    @Autowired
    public SistemaController(SistemaHandler _handler) {this._handler = _handler;}

    @Override
    public List<SistemaTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<SistemaTO> Post(SalvarSistemaCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<SistemaTO> Put(Long id, AtualizarSistemaCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarSistemaCommand command, Long id)
    {
        return _handler.Handler(command, id);
    }
}
