package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.backend.gcmd.enums.typePaiementEnum;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BulltinPrestationDTO {

    private Long id;

    private String description;

    private OffsetDateTime date;

    private OffsetTime heure;

    private Integer numeroDossierPrestation;

    private typePaiementEnum typePaiement;

    private Integer codeClient;

    private String nomClient;

    private Integer numeroEscale;

    private boolean moyenOdepClient;

    private Integer codeNature;

    private boolean preValidation;

    private Date dateDepot;

    private Date dateProbableExecution;

    private String texte;

    private Integer numeroCmd;
}
