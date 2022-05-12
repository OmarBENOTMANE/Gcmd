package org.backend.gcmd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Gcmd_ligne_devis")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneDevisEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String designation;
	private Integer quantite;
	private Double nombreUnite;
	private Double total;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DevisEntity.class)
	@JoinColumn(name = "devis_id", nullable = true, insertable = false, updatable = false)
	private DevisEntity devis;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PrestationEntity.class)
	@JoinColumn(name = "prestation_id", nullable = true, insertable = false, updatable = false)
	private PrestationEntity prestation;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
