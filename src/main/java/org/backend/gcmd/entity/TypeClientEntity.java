package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    private List<ClientEntity> clients;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public Boolean getDeleted() { return deleted = false;}
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

}
