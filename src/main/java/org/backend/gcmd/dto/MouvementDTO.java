package org.backend.gcmd.dto;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MouvementDTO {

    private Long id;

    private String description;

    private Date dateMouvement;

    private Long navirId;
}
