package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    Boolean existsByUsernameAndPassword(String user,String password);
    @Query(value = "select u.* from usuario u where u.D_E_L_E_T_= ''", nativeQuery = true)
    List<UsuarioEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
