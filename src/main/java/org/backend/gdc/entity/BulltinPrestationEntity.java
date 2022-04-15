package org.backend.gdc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gdc.enums.typePaiementEnum;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "gcmd_bulltin_prestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BulltinPrestationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date date;

    private Date heure;

    private Integer n_dossier_prestation;

    @Enumerated(EnumType.ORDINAL)
    private typePaiementEnum typePaiement;

    private Integer code_client;

    private String nom_client;

    private Integer n_escale;

    private boolean moyen_odep_client;

    private Integer code_nature;

    private boolean pre_validation;

    private Date date_depot;

    private Date date_probable_execution;

    private String texte;

    private Integer numero_cmd;


}
