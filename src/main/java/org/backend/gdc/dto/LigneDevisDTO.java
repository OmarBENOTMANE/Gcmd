package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class LigneDevisDTO {


    private Long id;

    private String designation;
    private int quantite;
    private double nombre_unite;
    private double total;

}
