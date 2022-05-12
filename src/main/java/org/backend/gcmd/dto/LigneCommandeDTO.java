package org.backend.gcmd.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.backend.gcmd.enums.SenstraficEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LigneCommandeDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String prestation;

	private LocalDate date;

	private LocalTime heure;

	private SenstraficEnum sensTrafic;

	private String produit;

	private String tcSuppl;

	private Boolean tcConv;

	private Integer nombre;

	private Boolean tarifUnifie;

	private Integer tonnageReel;

	private Integer tonnageMinimum;

	private String description;

	private Long commandeId;

	private Long prestationId;

	private Boolean deleted = false;

	private Boolean isAffected = false;

}
