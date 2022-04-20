package org.backend.gcmd.dto;

import lombok.Data;
import org.backend.gcmd.enums.SenstraficEnum;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class LigneBpDTO {

    private Long id;

    private String prestation;

    private LocalDate date;

    private LocalTime heure;

    private SenstraficEnum sensTrafic;

    private String produit;

    private String tcSuppl;

    private Boolean tcConv;

    private Integer nombre;

    private Boolean tarifUnifie;

    private Integer tonnageReel;

    private Integer tonnageMinimum;

    private Long bulltinprestationId;
}
