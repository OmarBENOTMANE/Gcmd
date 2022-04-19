package org.backend.gcmd.dto;

import lombok.Data;
import org.backend.gcmd.enums.SenstraficEnum;

import java.util.Date;

@Data
public class LigneBpDTO {

    private Long id;

    private String prestation;

    private Date date;

    private Date heure;

    private SenstraficEnum sensTrafic;

    private String produit;

    private String tcSuppl;

    private boolean tcConv;

    private Integer nombre;

    private boolean tarifUnifie;

    private Integer tonnageReel;

    private Integer tonnageMinimum;

    private Long bulltinprestationId;
}
