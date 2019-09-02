package br.edu.projectdefault.Domain.Handler;

import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.AtualizarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.DeletarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.SalvarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Outputs.AcessoTO;
import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import br.edu.projectdefault.Domain.IRepository.IAcessoRepository;
import br.edu.projectdefault.Infrastructure.repository.AcessoRepository;
import br.edu.projectdefault.Infrastructure.repository.UsuarioRepository;
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
    private final UsuarioRepository _repositoryUser;

    @Autowired
    public AcessoHandler(AcessoRepository _repository, UsuarioRepository repositoryUser)
    {
        this._repository = _repository;
        _repositoryUser = repositoryUser;
    }

    public List<AcessoTO> Handler()
    {
        List<AcessoEntity> entity = _repository.findAllByD_E_L_E_T_("");
        return AcessoTO.converter(entity);
    }

    public ResponseEntity<AcessoTO> Handler(SalvarAcessoCommand command, UriComponentsBuilder builder)
    {
        command.entity = _repositoryUser.getOne(command.entity.getId());
        AcessoEntity entity = new AcessoEntity(command);
        entity.setD_E_L_E_T_("");
        _repository.save(entity);
        URI uri = builder.path("/acesso/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new AcessoTO(entity));
    }

    @Override
    public ResponseEntity<AcessoTO> Handler(Long id, AtualizarAcessoCommand command)
    {
     AcessoEntity entity = command.Update(id,_repository);
     return  ResponseEntity.ok(new AcessoTO(entity));
    }

    @Override
    public ResponseEntity Handler(DeletarAcessoCommand command, Long id)
    {
        command.setD_E_L_E_T_("*");
        command.Update(id,_repository);
        return ResponseEntity.ok().build();
    }
}
