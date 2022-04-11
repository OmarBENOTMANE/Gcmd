package org.backend.gdc.repository;

import org.backend.gdc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    @RestResource(path = "/bytype")//http://localhost:3230/comptes/search/bytype?type=EPARGNE
//    List<User> findByType(@Param(value="type") TypeCompte typeCompte);//filtre
}
