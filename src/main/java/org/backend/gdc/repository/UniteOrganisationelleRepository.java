package org.backend.gdc.repository;

import org.backend.gdc.entity.UniteOrganisationelleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteOrganisationelleRepository extends JpaRepository<UniteOrganisationelleEntity, Long> {
}