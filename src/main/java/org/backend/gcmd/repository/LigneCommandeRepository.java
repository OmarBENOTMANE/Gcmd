package org.backend.gcmd.repository;

import org.backend.gcmd.entity.LigneCommandeEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommandeEntity, Long> {

    Page<LigneCommandeEntity> findAllByDeletedFalse(Pageable page);
    Page<LigneCommandeEntity> findAllByCommande_Id(Long id, Pageable page);
    List<LigneCommandeEntity> findAllByCommande_Id(Long id);

}
