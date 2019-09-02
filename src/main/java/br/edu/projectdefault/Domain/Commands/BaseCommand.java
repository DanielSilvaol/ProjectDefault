package br.edu.projectdefault.Domain.Commands;

public interface BaseCommand<T,R>
{
        public T Update(Long id,R _repository);
}
