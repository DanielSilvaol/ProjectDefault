package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.AtualizarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.DeletarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Inputs.SalvarInfoUsuarioCommand;
import br.edu.GEP.Domain.Commands.InfoUsuarioCommand.Outputs.InfoUsuarioTO;
import br.edu.GEP.Infrastructure.repository.InfoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Service
public class InfoUsuarioHandler implements BaseHandler<InfoUsuarioTO, SalvarInfoUsuarioCommand, AtualizarInfoUsuarioCommand, DeletarInfoUsuarioCommand>
{
    private final InfoUsuarioRepository _repository;

    @Autowired
    public InfoUsuarioHandler(InfoUsuarioRepository _repository) {this._repository = _repository;}

    @Override
    public List<InfoUsuarioTO> Handler()
    {
        return InfoUsuarioTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    @Override
    public ResponseEntity<InfoUsuarioTO> Handler(SalvarInfoUsuarioCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.InfoUsuarioEntity);
        URI uri = builder.path("/infoUsuario/{id}").buildAndExpand(command.InfoUsuarioEntity.getID()).toUri();
        return ResponseEntity.created(uri).body(new InfoUsuarioTO(command.InfoUsuarioEntity));
    }

    @Override
    public ResponseEntity<InfoUsuarioTO> Handler(Long id, AtualizarInfoUsuarioCommand command)
    {
        command.InfoUsuarioEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok(new InfoUsuarioTO(command.InfoUsuarioEntity));
    }

    @Override
    public ResponseEntity Handler(DeletarInfoUsuarioCommand command, Long id)
    {
        command.InfoUsuarioEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
