package org.backend.gcmd.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.backend.gcmd.enums.TypePaiementEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "gcmd_bulltin_prestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BulltinPrestationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private LocalDate date;

	private LocalTime heure;

	private Integer numeroDossierPrestation;

	@Enumerated(EnumType.ORDINAL)
	private TypePaiementEnum typePaiement;

	private Integer codeClient;

	private String nomClient;

	private Integer numeroEscale;

	private Boolean moyenOdepClient;

	private Integer codeNature;

	private Boolean preValidation;

	private LocalDate dateDepot;

	private LocalDate dateProbableExecution;

	private String text;

	private Integer numeroCmd;

	@OneToMany(mappedBy = "bulltinPrestation", fetch = FetchType.LAZY)
	private List<CommandeEntity> commandeList;

	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	private Boolean validated = false;

	private Boolean invoiced = false;
}
