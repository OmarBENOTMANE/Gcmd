package org.backend.gdc.dto;

import lombok.Data;

@Data
public class MarchandiseDTO {

    private Long id;
    private String Designation;
    private String reference;
    private double quantity;

}
