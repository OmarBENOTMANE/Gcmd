package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class PrestationDTO {

    private Long id;

    private String designation;

    private String type_prestation;

    private int type_tarif;


}
