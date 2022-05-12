package org.backend.gcmd.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementDTO {

	private Long id;

	private String description;

	private LocalDate dateMouvement;

	private Long navirId;

	private Boolean deleted = false;
}
