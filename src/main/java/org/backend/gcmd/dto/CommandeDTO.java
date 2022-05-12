package org.backend.gcmd.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommandeDTO {

	private Long id;

	private Integer numeroBc;

	private String navire;

	private String consignataire;

	private LocalDate dateAmarage;

	private LocalDate dateDesamarage;

	private Integer lht;

	private Double jaugeBrute;

	private String poste;

	private String capitaine;

	private Integer numeroEscale;

	private Integer mumeroCredit;

	private Integer mumeroCommande;

	private Integer connaissement;

	private Integer bulletinReception;

	private Long escaleId;

	private Long devisId;

	private Long bulltinPrestationId;

	private Boolean deleted = false;

}
