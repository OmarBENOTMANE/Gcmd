package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class MarchandiseDTO {

    private Long id;
    private String Designation;
    private String reference;
    private double quantity;

}
