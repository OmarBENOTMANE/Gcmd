package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.SenstraficEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    private String prestations;

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

    @ManyToOne
    @JoinColumn(name = "bulltin_prestation_id", nullable = true)
    private BulltinPrestationEntity bulltinPrestation;

    @OneToMany(mappedBy = "bulltinPrestation", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<LigneBpEntity> ligneBpList;

    private Boolean deleted = false;


}
