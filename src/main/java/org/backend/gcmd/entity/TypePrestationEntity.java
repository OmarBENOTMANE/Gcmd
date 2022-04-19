package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_type_prestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypePrestationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "typeprestation")
    private List<SousTypePrestationEntity> soustypeprestations;

    @OneToMany(mappedBy = "uniteorganisationel")
    private List<UniteOrganisationelleEntity> uniteOrgaisationels;
}
