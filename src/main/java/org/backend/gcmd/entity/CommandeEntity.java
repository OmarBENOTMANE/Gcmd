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

    @Column(name = "commande_id",insertable=false ,updatable = false)
    private Long commandeId;

    @Column(name = "escale_id",insertable=false ,updatable = false)
    private Long escaleId;

    @Column(name = "devis_id",insertable=false ,updatable = false)
    private Long devisId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id", nullable = false)
    private BulltinPrestationEntity commande;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommandeEntity> ligneCommandes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escale_id", nullable = false)
    private EscaleEntity escale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id", nullable = false)
    private DevisEntity devis;

}
