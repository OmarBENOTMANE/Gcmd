package org.backend.gcmd.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Gcmd_navire")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NavireEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer numeroEscale;
	private String consignataire;
	private LocalDate dateNavire;
	private String etat;

	@OneToMany(mappedBy = "navire")
	private List<MouvementEntity> mouvementList;

	@OneToMany(mappedBy = "navire")
	private List<EscaleEntity> escaleList;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
