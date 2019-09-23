package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Commands.AcessoCommand.Inputs.AtualizarAcessoCommand;
import br.edu.GEP.Domain.Commands.AcessoCommand.Inputs.DeletarAcessoCommand;
import br.edu.GEP.Domain.Commands.AcessoCommand.Inputs.SalvarAcessoCommand;
import br.edu.GEP.Domain.Commands.AcessoCommand.Outputs.AcessoTO;
import br.edu.GEP.Domain.Entity.AcessoEntity;
import br.edu.GEP.Infrastructure.repository.AcessoRepository;
import br.edu.GEP.Infrastructure.repository.ParametroRepository;
import br.edu.GEP.Infrastructure.repository.SistemaRepository;
import br.edu.GEP.Infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class AcessoHandler implements BaseHandler<AcessoTO, SalvarAcessoCommand, AtualizarAcessoCommand, DeletarAcessoCommand>
{
    private final AcessoRepository _repository;
    private final ParametroRepository _repositoryParametro;
    private final SistemaRepository _repositorySistema;
    private final UsuarioRepository _repositoryUsuario;

    @Autowired
    public AcessoHandler(AcessoRepository _repository, ParametroRepository repositoryParametro, SistemaRepository repositorySistema, UsuarioRepository repositoryUsuario)
    {
        this._repository = _repository;
        _repositoryParametro = repositoryParametro;
        _repositorySistema = repositorySistema;
        _repositoryUsuario = repositoryUsuario;
    }

    public List<AcessoTO> Handler()
    {
        return AcessoTO.converter(_repository.findAllByD_E_L_E_T_(""));
    }

    public ResponseEntity<AcessoTO> Handler(SalvarAcessoCommand command, UriComponentsBuilder builder)
    {
        command.configuration();
        _repository.save(command.AcessoEntity);
        URI uri = builder.path("/acesso/{id}").buildAndExpand(command.AcessoEntity.getID()).toUri();
        return ResponseEntity.created(uri).body(new AcessoTO(command.AcessoEntity));
    }

    @Override
    public ResponseEntity<AcessoTO> Handler(Long id, AtualizarAcessoCommand command)
    {
        command.AcessoEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok(new AcessoTO(command.AcessoEntity));
    }

    @Override
    public ResponseEntity Handler(DeletarAcessoCommand command, Long id)
    {
        command.AcessoEntity = _repository.findById(id).get();
        command.configuration();
        return ResponseEntity.ok().build();
    }
}
