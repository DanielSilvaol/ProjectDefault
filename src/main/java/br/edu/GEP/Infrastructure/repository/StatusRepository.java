package br.edu.GEP.Infrastructure.repository;

import br.edu.GEP.Domain.Entity.GEP_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<GEP_STATUS,Long>
{
    @Query(value = "select u.* from GEP_STATUS u where u.D_E_L_E_T_=?1", nativeQuery = true)
    List<GEP_STATUS> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
