package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Gcmd_tarif")
public class TarifEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tarifHt;

    private Double tarifTtc;

    @OneToOne(mappedBy = "tarif", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PrestationEntity prestation;

    @Column(name = "deleted")
    private Boolean deleted = false;

    public Boolean getDeleted() { return deleted = false;}
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

}
