package org.backend.gcmd.repository;

import org.backend.gcmd.entity.UniteOrganisationelleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteOrganisationelleRepository extends JpaRepository<UniteOrganisationelleEntity, Long> {
}