package org.backend.gcmd.repository;

import org.backend.gcmd.entity.BulltinPrestationEntity;
import org.backend.gcmd.entity.CommandeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {

    Page<CommandeEntity> findAllByDeletedFalse(Pageable page);
    Page<CommandeEntity> findCommandeEntitiesByBulltinPrestation_Id(Long bpId, Pageable pageable);
    Page<CommandeEntity> findCommandByBulltinPrestationIsNull(Pageable page);
}