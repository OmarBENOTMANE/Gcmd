package org.backend.gdc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.backend.gdc.enums.EngineColisEnum;
import org.backend.gdc.enums.ImportExportEnum;
import org.backend.gdc.enums.MmMcEnum;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "deviss")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DevisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_navire;
    private Date date;
    private int bl;
    private int nombre_colis;
    private double poids;
    private String designation;
    private ImportExportEnum import_export;
    private MmMcEnum MM_MC;
    private int numero_mafi;
    private EngineColisEnum engine_colis;
    private int numero_bon_commande;
    private String nom_client;
    private Date date_facturation;
    private Date date_sortie;

}
