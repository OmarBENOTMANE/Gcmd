package org.backend.gdc.repository;

import org.backend.gdc.entity.MarchandiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarchandiseRepository extends JpaRepository<MarchandiseEntity, Long> {
}