package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Gcmd_unite_orgaisationel")
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

    @Column(name = "uniteorganisationel_id", insertable = false, updatable = false)
    private Long uniteorganisationelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uniteorganisationel_id", nullable = false)
    private TypePrestationEntity uniteorganisationel;
}
