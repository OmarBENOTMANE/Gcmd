package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SousTypePrestationDTO {

    private Long id;

    private String name;

    private Long typeprestationId;


}
