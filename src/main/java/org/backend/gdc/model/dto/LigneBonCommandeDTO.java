package org.backend.gdc.model.dto;

import lombok.Data;
import org.backend.gdc.model.enums.SenstraficEnum;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class LigneBonCommandeDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
