package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.backend.gcmd.enums.typePaiementEnum;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulltinPrestationDTO {

    private Long id;

    private String description;

    private Date date;

    private Date heure;

    private Integer n_dossier_prestation;

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
