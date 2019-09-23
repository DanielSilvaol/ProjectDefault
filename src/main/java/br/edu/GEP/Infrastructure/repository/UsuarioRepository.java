package br.edu.GEP.Infrastructure.repository;

import br.edu.GEP.Domain.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    @Query(value = "select u.* from usuario u where u.D_E_L_E_T_=?1", nativeQuery = true)
    List<UsuarioEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
