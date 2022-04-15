package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.backend.gcmd.enums.SenstraficEnum;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LigneCommandeDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prestation;

    private Date date;

    private Date heure;

    private SenstraficEnum sensTrafic;

    private String produit;

    private String tcSuppl;

    private boolean tcConv;

    private Integer nombre;

    private boolean tarifUnifie;

    private Integer tonnageReel;

    private Integer tonnageMinimum;

    private String description;

}
