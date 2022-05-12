package org.backend.gcmd.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Gcmd_type_client")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "typeClient", fetch = FetchType.LAZY)
	private List<ClientEntity> clientList;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
