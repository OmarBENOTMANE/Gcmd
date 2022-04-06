package org.backend.gdc.dto;

import lombok.*;
import org.backend.gdc.enums.SenstraficEnum;
import javax.persistence.*;
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
