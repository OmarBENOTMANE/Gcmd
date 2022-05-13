package org.backend.gcmd.repository;

import org.backend.gcmd.entity.LigneBpEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneBpRepository extends JpaRepository<LigneBpEntity, Long> {

    Page<LigneBpEntity> findAllByDeletedFalse(Pageable page);

    List<LigneBpEntity> findByIdLigneCommande(Long idLigneCommande);

}