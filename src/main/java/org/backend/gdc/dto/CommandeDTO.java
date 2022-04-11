package org.backend.gdc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeDTO {

    private Long id;

    private int numero_bc;

    private String navire;

    private String consignataire;

    private Date date_amarage;

    private Date date_desamarage;

    private int lht;

    private double jaugebrute;

    private String poste;

    private String capitaine;

    private int numero_escale;

    private int mumero_credit;

    private int mumero_commande;

    private int connaissement;

    private int bulletin_reception;
}
