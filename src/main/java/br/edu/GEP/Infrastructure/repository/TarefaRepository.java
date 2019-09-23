package br.edu.GEP.Infrastructure.repository;

import br.edu.GEP.Domain.Entity.GEP_TAREFA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<GEP_TAREFA,Long>
{
    @Query(value = "select u.* from GEP_TAREFA u where u.D_E_L_E_T_= ?1", nativeQuery = true)
    List<GEP_TAREFA> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
