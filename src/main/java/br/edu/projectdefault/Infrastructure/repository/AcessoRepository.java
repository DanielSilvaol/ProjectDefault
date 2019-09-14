package br.edu.projectdefault.Infrastructure.repository;

import br.edu.projectdefault.Domain.Entity.AcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AcessoRepository extends JpaRepository<AcessoEntity,Long>
{
    @Query(value = "select u.* from geral_acesso u where u.D_E_L_E_T_= ?1", nativeQuery = true)
    List<AcessoEntity> findAllByD_E_L_E_T_(String D_E_L_E_T_);
}
