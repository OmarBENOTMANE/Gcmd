package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementDTO {

    private Long id;

    private String description;

    private LocalDate dateMouvement;

    private Long navirId;
}
