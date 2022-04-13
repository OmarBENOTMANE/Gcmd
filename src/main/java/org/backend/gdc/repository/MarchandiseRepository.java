package org.backend.gdc.repository;

import org.backend.gdc.entity.MarchandiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarchandiseRepository extends JpaRepository<MarchandiseEntity, Long> {
}