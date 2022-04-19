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

    private Integer typeTarif;


    @OneToMany(mappedBy = "prestation")
    private List<LigneDevisEntity> prestationLigneDevis;

    @OneToMany(mappedBy = "prestation")
    private List<TarifEntity> tarifs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soustypeprestation_id", nullable = false)
    private SousTypePrestationEntity soustypeprestation;

    @Column(name = "soustypeprestation_id")
    private Long soustypeprestationId;
}
