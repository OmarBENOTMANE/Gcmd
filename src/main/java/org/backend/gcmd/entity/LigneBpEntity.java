package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.SenstraficEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Table(name = "gcmd_ligne_bp")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneBpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prestation;

    private LocalDate date;

    private LocalTime heure;

    @Enumerated(EnumType.STRING)
    private SenstraficEnum sensTrafic;

    private String produit;

    private String tcSuppl;

    private Boolean tcConv;

    private Integer nombre;

    private Boolean tarifUnifie;

    private Integer tonnageReel;

    private Integer tonnageMinimum;

    @Column(name = "bulltinprestation_id")
    private Long bulltinprestationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bulltinprestation_id", nullable = false, insertable = false, updatable = false)
    private BulltinPrestationEntity bulltinprestation;

}
