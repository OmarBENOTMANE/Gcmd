package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Gcmd_ligne_devis")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneDevisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private Integer quantite;
    private Double nombreUnite;
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id")
    private DevisEntity devis;

    @Column(name = "devis_id", nullable=false, insertable=false, updatable=false)
    private Long devisId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestation_id")
    private PrestationEntity prestation;

    @Column(name = "prestation_id", nullable=false, insertable=false, updatable=false)
    private Long prestationId;


}
