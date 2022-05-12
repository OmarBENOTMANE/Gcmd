package org.backend.gcmd.entity;

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
@Table(name = "Gcmd_soustypeprestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SousTypePrestationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "soustypeprestation", fetch = FetchType.LAZY)
	private List<PrestationEntity> prestationList;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = TypePrestationEntity.class)
	@JoinColumn(name = "typeprestation_id", nullable = true, insertable = false, updatable = false)
	private TypePrestationEntity typeprestation;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
