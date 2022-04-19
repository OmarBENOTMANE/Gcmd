package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommandeDTO {

    private Long id;

    private Integer numeroBc;

    private String navire;

    private String consignataire;

    private Date dateAmarage;

    private Date dateDesamarage;

    private Integer lht;

    private double jaugeBrute;

    private String poste;

    private String capitaine;

    private Integer numeroEscale;

    private Integer mumeroCredit;

    private Integer mumeroCommande;

    private Integer connaissement;

    private Integer bulletinReception;

    private Long commandeId;

    private Long escaleId;

    private Long devisId;
}
