package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneDevisDTO {


    private Long id;

    private String designation;
    private Integer quantite;
    private double nombreUnite;
    private double total;

}
