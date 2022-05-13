package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.TypePaiementEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Table(name = "gcmd_bulltin_prestation")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BulltinPrestationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate date;

    private LocalTime heure;

    private Integer numeroDossierPrestation;

    @Enumerated(EnumType.ORDINAL)
    private TypePaiementEnum typePaiement;

    private Integer codeClient;

    private String nomClient;

    private Integer numeroEscale;

    private Boolean moyenOdepClient;

    private Integer codeNature;

    private Boolean preValidation;

    private LocalDate dateDepot;

    private LocalDate dateProbableExecution;

    private String text;

    private Integer numeroCmd;

    @OneToMany(mappedBy = "bulltinPrestation", fetch = FetchType.LAZY)
    private List<CommandeEntity> commandeList;

    private Boolean deleted = false;

    private Boolean validated = false;
    private Boolean invoiced = false;

    public Boolean getDeleted() {
        return deleted = false;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
