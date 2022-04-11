package org.backend.gdc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gdc.enums.SenstraficEnum;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "lignecommande")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneCommandeEntity {


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

    private String description;

}
