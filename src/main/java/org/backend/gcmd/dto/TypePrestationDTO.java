package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypePrestationDTO {

    private Long id;

    private String name;

    private Boolean deleted = false;

}
