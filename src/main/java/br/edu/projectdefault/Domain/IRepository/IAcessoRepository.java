package br.edu.projectdefault.Domain.IRepository;

import br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs.SalvarAcessoCommand;
import br.edu.projectdefault.Domain.Commands.AcessoCommand.Outputs.AcessoTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface IAcessoRepository
{
    List<AcessoTO> Handler();
    ResponseEntity<AcessoTO> Handler(SalvarAcessoCommand command, UriComponentsBuilder builder) throws Exception;
}
