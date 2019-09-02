package br.edu.projectdefault.Domain.Handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface BaseHandler<T, S, A,D>
{
    //ListarEntityTO
    List<T> Handler();

    //SalvarEntity
    ResponseEntity<T> Handler(S command, UriComponentsBuilder builder);

    //AtualizarEntity
    ResponseEntity<T> Handler(Long id, A command);

    //DeletarEntity
    ResponseEntity Handler(D command,Long id);
}
