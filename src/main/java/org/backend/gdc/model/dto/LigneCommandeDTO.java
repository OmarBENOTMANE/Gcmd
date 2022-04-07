package org.backend.gdc.dto;

import lombok.Data;
import org.backend.gdc.enums.SenstraficEnum;

import java.util.Date;

@Data
public class LigneCommandeDTO {

    private Long id;
    private String prestation;

    private Date date;

    private Date heure;

    private SenstraficEnum sensTrafic;

    private String produit;

    private String tc_suppl;

    private boolean tc_conv;

    private int nombre;

    private boolean tarif_unifie;

    private int tonnageReel;

    private int tonnageMinimum;

    private String description;
}
