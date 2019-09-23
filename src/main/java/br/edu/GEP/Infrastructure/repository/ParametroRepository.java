package br.edu.GEP.Infrastructure.repository;

import br.edu.GEP.Domain.Entity.ParametroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParametroRepository extends JpaRepository<ParametroEntity,Long>
{
    @Query(value = "select p.* from parametro p where p.D_E_L_E_T_= ?1", nativeQuery = true)
    List<ParametroEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
