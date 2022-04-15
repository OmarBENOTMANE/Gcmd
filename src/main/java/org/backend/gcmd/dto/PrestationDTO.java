package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrestationDTO {

    private Long id;

    private String designation;

    private String typePrestation;

    private Integer typeTarif;


}
