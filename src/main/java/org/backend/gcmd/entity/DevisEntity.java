package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.EnginsColisEnum;
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
    private MmMcEnum mmMc;
    private Integer numeroMafi;

    @Enumerated(EnumType.STRING)
    private EnginsColisEnum enginsColis;

    private Integer numeroCommande;
    private String nomClient;
    private LocalDate dateFacturation;
    private LocalDate dateSortie;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = EscaleEntity.class)
    @JoinColumn(name = "escale_id", insertable = false, updatable = false)
    private EscaleEntity escale;

    @Column(name = "escale_id", nullable = false)
    private Long escaleId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClientEntity.class)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientEntity client;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @OneToMany(mappedBy = "devis", fetch = FetchType.LAZY)
    private List<LigneDevisEntity> ligneDevisList;

    @OneToMany(mappedBy = "devis", fetch = FetchType.LAZY)
    private List<CommandeEntity> commandeList;
}
