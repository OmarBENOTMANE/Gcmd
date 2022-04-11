package org.backend.gdc.repository;

import org.backend.gdc.entity.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {
}