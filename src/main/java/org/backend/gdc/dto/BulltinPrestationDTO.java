package org.backend.gdc.dto;

import lombok.Data;
import org.backend.gdc.enums.typePaiementEnum;

import java.util.Date;

@Data
public class BulltinPrestationDTO {

    private Long id;
    private String description;

    private Date date;

    private Date heure;

    private int n_dossier_prestation;

    private typePaiementEnum typePaiement;

    private int code_client;

    private String nom_client;

    private int escale;

    private boolean moyen_odep_client;

    private int code_nature;

    private boolean pre_validation;

    private Date date_depot;

    private Date date_probable_execution;

    private String texte;

    private boolean numero_bon_cmd;

    private int numero_cmd;
}
