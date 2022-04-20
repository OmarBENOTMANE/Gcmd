package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UniteOrganisationelDTO {

    private Long id;

    private String label;

    private String type;

    private String description;

    private Long uniteorganisationelId;
}