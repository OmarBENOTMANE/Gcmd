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
@Table(name = "Gcmd_escale")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EscaleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroEscale;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = NavireEntity.class)
	@JoinColumn(name = "navire_id", nullable = true, insertable = false, updatable = false)
	private NavireEntity navire;

	@OneToMany(mappedBy = "escale", fetch = FetchType.LAZY)
	private List<MarchandiseEntity> marchandiseList;

	@OneToMany(mappedBy = "escale", fetch = FetchType.LAZY)
	private List<DevisEntity> devisList;

	@OneToMany(mappedBy = "escale", fetch = FetchType.LAZY)
	private List<CommandeEntity> CommandeList;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
