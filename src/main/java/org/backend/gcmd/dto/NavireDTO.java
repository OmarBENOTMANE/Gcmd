package org.backend.gcmd.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NavireDTO {

    private Long id;
    private String name;
    private Double numero_escale;
    private String consignataire;
    private Date date_navire;
    private String etat;

}