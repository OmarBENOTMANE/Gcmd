package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "devis_id", nullable = true)
    private DevisEntity devis;

    @ManyToOne
    @JoinColumn(name = "prestation_id", nullable = true)
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
