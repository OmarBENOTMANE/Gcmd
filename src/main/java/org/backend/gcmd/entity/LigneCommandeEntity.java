package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.SenstraficEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Table(name = "Gcmd_ligne_commande")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneCommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prestations;

    private LocalDate date;

    private LocalTime heure;

    @Enumerated(EnumType.STRING)
    private SenstraficEnum sensTrafic;

    private String produit;

    private String tcSuppl;

    private Boolean tcConv;

    private Integer nombre;

    private Boolean tarifUnifie;

    private Integer tonnageReel;

    private Integer tonnageMinimum;

    private String description;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = true)
    private CommandeEntity commande;

    @ManyToOne
    @JoinColumn(name = "prestation_id", nullable = true)
    private PrestationEntity prestation;

    private Boolean deleted = false;

    private Boolean isAffected = false;

}

