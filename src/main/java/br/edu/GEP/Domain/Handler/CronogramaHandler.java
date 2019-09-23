package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.AtualizarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.DeletarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Inputs.SalvarCronogramaCommand;
import br.edu.GEP.Domain.Commands.CronogramaCommand.Outputs.CronogramaTO;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Outputs.ProjetoTO;
import br.edu.GEP.Infrastructure.repository.CronogramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class CronogramaHandler implements BaseHandler<CronogramaTO, SalvarCronogramaCommand, AtualizarCronogramaCommand, DeletarCronogramaCommand>
{
    private final CronogramaRepository _repository;

    @Autowired
    public CronogramaHandler(CronogramaRepository _repository) {this._repository = _repository;}

    @Override
    public List<CronogramaTO> Handler()
    {
        return CronogramaTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<CronogramaTO> Handler(SalvarCronogramaCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.GEP_CRONOGRAMA);
        URI uri = builder.path("/cronograma/{id}").buildAndExpand(command.GEP_CRONOGRAMA.getID()).toUri();
         return ResponseEntity.created(uri).body(new CronogramaTO(command.GEP_CRONOGRAMA));
    }

    @Override
    public ResponseEntity<CronogramaTO> Handler(Long id, AtualizarCronogramaCommand command)
    {
        command.GEP_CRONOGRAMA = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok(new CronogramaTO(command.GEP_CRONOGRAMA));
    }

    @Override
    public ResponseEntity Handler(DeletarCronogramaCommand command, Long id)
    {
        command.GEP_CRONOGRAMA = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
