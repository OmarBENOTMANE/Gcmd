package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.EngineColisEnum;
import org.backend.gcmd.enums.ImportExportEnum;
import org.backend.gcmd.enums.MmMcEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Table(name = "Gcmd_devis")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DevisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomNavire;
    private LocalDate date;
    private Integer bl;
    private Integer nombreColis;
    private Double poids;
    private String designation;

    @Enumerated(EnumType.STRING)
    private ImportExportEnum importExport;

    @Enumerated(EnumType.STRING)
    private MmMcEnum MmMc;
    private Integer numeroMafi;

    @Enumerated(EnumType.STRING)
    private EngineColisEnum engineColis;

    private Integer numeroCommande;
    private String nomClient;
    private LocalDate dateFacturation;
    private LocalDate dateSortie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escale_id", nullable = false)
    private EscaleEntity escale;

    @Column(name = "escale_id",insertable=false ,updatable = false)
    private Long escaleId;

    @OneToMany(mappedBy = "devis")
    private List<CommandeEntity> commandes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id", nullable = false)
    private ClientEntity devis;

    @Column(name = "devis_id",insertable=false ,updatable = false)
    private Long devisId;

    @OneToMany(mappedBy = "devis")
    private List<LigneDevisEntity> ligneDevis;
}
