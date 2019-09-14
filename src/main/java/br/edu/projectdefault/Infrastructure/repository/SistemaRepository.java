package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.SistemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SistemaRepository extends JpaRepository<SistemaEntity,Long>
{
    @Query(value = "select s.* from sistema s where s.D_E_L_E_T_= ?1", nativeQuery = true)
    List<SistemaEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
