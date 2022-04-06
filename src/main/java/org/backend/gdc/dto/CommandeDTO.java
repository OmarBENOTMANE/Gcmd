package org.backend.gdc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommandeDTO {

    private Long id;
    private int mumero_credit;
    private int numero_commande;
    private String navire;
    private int connaissement;
    private int bulletin_reception;
}
