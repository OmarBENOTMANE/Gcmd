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
@Table(name = "Gcmd_marchandise")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MarchandiseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private String reference;
	private Double quantite;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EscaleEntity.class)
	@JoinColumn(name = "escale_id", nullable = true, insertable = false, updatable = false)
	private EscaleEntity escale;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
