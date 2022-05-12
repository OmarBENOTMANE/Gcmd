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
@Table(name = "Gcmd_client")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String phone;

	@OneToMany(mappedBy = "client")
	private List<DevisEntity> devisList;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_client_id", nullable = false, insertable = false, updatable = false)
	private TypeClientEntity typeClient;

	@Column(name = "type_client_id")
	private Long typeClientId;

	@Column(name = "deleted")
	private Boolean deleted = false;

	public Boolean getDeleted() {
		return deleted = false;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
