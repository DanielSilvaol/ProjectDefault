package br.edu.GEP.Infrastructure.controller;

import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.AtualizarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.DeletarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.SalvarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Outputs.CronogramaTO;
import br.edu.GEP.Domain.Handler.CronogramaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Cronograma")
public class CronogramaController implements BaseController<CronogramaTO, SalvarCronogramaCommand, AtualizarCronogramaCommand, DeletarCronogramaCommand>
{

    private final CronogramaHandler _handler;

    @Autowired
    public CronogramaController(CronogramaHandler _handler) {this._handler = _handler;}

    @Override
    public List<CronogramaTO> Get()
    {
        return _handler.Handler();
    }

    @Override
    public ResponseEntity<CronogramaTO> Post(SalvarCronogramaCommand command, UriComponentsBuilder builder)
    {
        return _handler.Handler(command, builder);
    }

    @Override
    public ResponseEntity<CronogramaTO> Put(Long id, AtualizarCronogramaCommand command)
    {
        return _handler.Handler(id, command);
    }

    @Override
    public ResponseEntity Delete(DeletarCronogramaCommand command, Long id)
    {
        return _handler.Handler(command, id);
    }
}
