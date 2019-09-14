package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.InfoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfoUsuarioRepository extends JpaRepository<InfoUsuarioEntity,Long>
{
    @Query(value = "select info.* from info_usuario info where info.D_E_L_E_T_= ?1", nativeQuery = true)
    List<InfoUsuarioEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
