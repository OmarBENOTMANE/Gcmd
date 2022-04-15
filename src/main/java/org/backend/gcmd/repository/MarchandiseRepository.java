package org.backend.gcmd.repository;

import org.backend.gcmd.entity.MarchandiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarchandiseRepository extends JpaRepository<MarchandiseEntity, Long> {
}