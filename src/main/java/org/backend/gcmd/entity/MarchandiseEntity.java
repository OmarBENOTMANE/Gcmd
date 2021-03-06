package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Boolean getDeleted() { return deleted = false;}
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }

}
