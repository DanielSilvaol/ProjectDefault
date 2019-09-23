package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.AtualizarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.DeletarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Inputs.SalvarProjetoCommand;
import br.edu.GEP.Domain.Commands.ProjetoCommand.Outputs.ProjetoTO;
import br.edu.GEP.Domain.Commands.SistemaCommand.Outputs.SistemaTO;
import br.edu.GEP.Infrastructure.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class ProjetoHandler implements BaseHandler<ProjetoTO, SalvarProjetoCommand, AtualizarProjetoCommand, DeletarProjetoCommand>
{
    private final ProjetoRepository _repository;

    @Autowired
    public ProjetoHandler(ProjetoRepository _repository) {this._repository = _repository;}

    @Override
    public List<ProjetoTO> Handler()
    {
        return ProjetoTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<ProjetoTO> Handler(SalvarProjetoCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.GEP_PROJETO);
        URI uri = builder.path("/projeto/{id}").buildAndExpand(command.GEP_PROJETO.getID()).toUri();
        return ResponseEntity.created(uri).body(new ProjetoTO(command.GEP_PROJETO));
    }

    @Override
    public ResponseEntity<ProjetoTO> Handler(Long id, AtualizarProjetoCommand command)
    {
        command.GEP_PROJETO = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok(new ProjetoTO(command.GEP_PROJETO));
    }

    @Override
    public ResponseEntity Handler(DeletarProjetoCommand command, Long id)
    {
        command.GEP_PROJETO = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
