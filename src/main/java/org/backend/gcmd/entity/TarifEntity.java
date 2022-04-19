package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Gcmd_tarif")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TarifEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double tarifHt;

    private double tarifTtc;

    @Column(name = "prestation_id")
    private Long prestationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestation_id", nullable = false)
    private PrestationEntity prestation;

}
