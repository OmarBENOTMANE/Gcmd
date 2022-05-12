package org.backend.gcmd.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Gcmd_commande")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommandeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EscaleEntity.class)
	@JoinColumn(name = "escale_id", nullable = true, insertable = false, updatable = false)
	private EscaleEntity escale;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DevisEntity.class)
	@JoinColumn(name = "devis_id", nullable = true, insertable = false, updatable = false)
	private DevisEntity devis;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BulltinPrestationEntity.class)
	@JoinColumn(name = "bulltin_prestation_id", nullable = true, insertable = false, updatable = false)
	private BulltinPrestationEntity bulltinPrestation;

	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
	private List<LigneCommandeEntity> ligneCommandeList;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
