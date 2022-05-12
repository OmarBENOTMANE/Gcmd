package org.backend.gcmd.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NavireDTO {

	private Long id;
	private String name;
	private Integer numeroEscale;
	private String consignataire;
	private LocalDate dateNavire;
	private String etat;

	private Boolean deleted = false;
}
