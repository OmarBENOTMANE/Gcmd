package org.backend.gcmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NavireDTO {

    private Long id;
    private String name;
    private Double numeroEscale;
    private String consignataire;
    private Date dateNavire;
    private String etat;

}
