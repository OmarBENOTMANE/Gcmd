package org.backend.gdc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DevisDTO {

    private Long id;
    private String nom_navire;
    private Date date;
    private int BL;
    private int nombre_colis;
    private double poids;
    private String designation;
    private boolean import_export;
    private boolean MM_MC;
    private int numero_mafi;
    private boolean engins_colis;
    private int num_bon_commande;
    private String nom_client;
    private Date date_facturation;
    private Date date_sortie;

}
