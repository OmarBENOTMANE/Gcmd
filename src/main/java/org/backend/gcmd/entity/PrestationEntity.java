package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_prestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrestationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;

    private String typePrestation;

    private String typeTarif;

    @OneToMany(mappedBy = "prestation")
    private List<LigneDevisEntity> ligneDevisList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tarif_id")
    private TarifEntity tarif;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SousTypePrestationEntity.class)
    @JoinColumn(name = "soustypeprestation_id", nullable = true, insertable = false, updatable = false)
    private SousTypePrestationEntity soustypeprestation;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public Boolean getDeleted() { return deleted = false;}
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

}
