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
    private List<SousTypePrestationEntity> soustypeprestationList;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UniteOrganisationelEntity.class)
    @JoinColumn(name = "unite_organisationel_id", nullable = true, insertable = false, updatable = false)
    private UniteOrganisationelEntity uniteOrganisationel;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public Boolean getDeleted() { return deleted = false;}
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

}
