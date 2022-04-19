package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.backend.gcmd.enums.EngineColisEnum;
import org.backend.gcmd.enums.ImportExportEnum;
import org.backend.gcmd.enums.MmMcEnum;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DevisDTO {

    private Long id;
    private String nomNavire;
    private Date date;
    private Integer bl;
    private Integer nombreColis;
    private double poids;
    private String designation;
    private ImportExportEnum importExport;
    private MmMcEnum MmMc;
    private Integer numeroMafi;
    private EngineColisEnum engineColis;
    private Integer numeroCommande;
    private String nomClient;
    private Date dateFacturation;
    private Date dateSortie;

    private Long escaleId;
    private Long devisId;
}
