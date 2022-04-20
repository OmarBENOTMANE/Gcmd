package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "soustypeprestation")
    private List<PrestationEntity> prestations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeprestation_id", nullable = false)
    private TypePrestationEntity typeprestation;

    @Column(name = "typeprestation_id",insertable=false ,updatable = false)
    private Long typeprestationId;
}
