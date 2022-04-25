package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_commande")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroBc;

    private String navire;

    private String consignataire;

    private LocalDate dateAmarage;

    private LocalDate dateDesamarage;

    private Integer lht;

    private Double jaugeBrute;

    private String poste;

    private String capitaine;

    private Integer numeroEscale;

    private Integer mumeroCredit;

    private Integer mumeroCommande;

    private Integer connaissement;

    private Integer bulletinReception;

//
    @Column(name = "escale_id", nullable = false, insertable = false, updatable = false)
    private Long escaleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escale_id")
    private EscaleEntity escale;

//
    @Column(name = "devis_id", nullable = false, insertable = false, updatable = false)
    private Long devisId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id")
    private DevisEntity devis;

    @Column(name = "bulltin_prestation_id", nullable = false, insertable = false, updatable = false)
    private Long bulltinPrestationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bulltin_prestation_id")
    private BulltinPrestationEntity bulltinPrestation;

    @OneToMany(mappedBy = "commande",fetch = FetchType.LAZY)
    private List<LigneCommandeEntity> ligneCommandeList;


}
