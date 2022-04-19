package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gcmd.enums.typePaiementEnum;
import javax.persistence.*;
import java.util.Date;
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

    private Date date;

    private Date heure;

    private Integer numeroDossierPrestation;

    @Enumerated(EnumType.ORDINAL)
    private typePaiementEnum typePaiement;

    private Integer codeClient;

    private String nomClient;

    private Integer numeroEscale;

    private boolean moyenOdepClient;

    private Integer codeNature;

    private boolean preValidation;

    private Date dateDepot;

    private Date dateProbableExecution;

    private String text;

    private Integer numeroCmd;

    @OneToMany(mappedBy = "bulltinprestation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneBpEntity> bulltinprestations;

    @OneToMany(mappedBy = "commande")
    private List<CommandeEntity> commandes;
}
