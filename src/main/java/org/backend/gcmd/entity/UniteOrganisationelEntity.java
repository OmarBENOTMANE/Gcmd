package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_unite_organisationel")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UniteOrganisationelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String type;

    private String description;

    @OneToMany(mappedBy = "uniteOrganisationel", fetch = FetchType.LAZY)
    private List<TypePrestationEntity> typePrestationList;

}
