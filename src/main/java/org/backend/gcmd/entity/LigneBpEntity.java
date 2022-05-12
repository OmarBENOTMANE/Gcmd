package org.backend.gcmd.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.backend.gcmd.enums.SenstraficEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "gcmd_ligne_bp")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneBpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String prestation;

	private LocalDate date;

	private LocalTime heure;

	@Enumerated(EnumType.STRING)
	private SenstraficEnum sensTrafic;

	private String produit;

	private String tcSuppl;

	private Boolean tcConv;

	private Integer nombre;

	private Boolean tarifUnifie;

	private Integer tonnageReel;

	private Integer tonnageMinimum;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BulltinPrestationEntity.class)
	@JoinColumn(name = "bulltin_prestation_id", nullable = true, insertable = false, updatable = false)
	private BulltinPrestationEntity bulltinprestation;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
