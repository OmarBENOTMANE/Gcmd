package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
public class NavireDTO {

    private Long id;
    private String name;
    private double numero_escale;
    private String consignataire;
    private Date date_navire;
    private String etat;

}
