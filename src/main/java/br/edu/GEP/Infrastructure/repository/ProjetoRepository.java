package br.edu.GEP.Infrastructure.repository;

import br.edu.GEP.Domain.Entity.GEP_PROJETO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<GEP_PROJETO,Long>
{
    @Query(value = "select u.* from GEP_PROJETO u where u.D_E_L_E_T_= ?1", nativeQuery = true)
    List<GEP_PROJETO> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
