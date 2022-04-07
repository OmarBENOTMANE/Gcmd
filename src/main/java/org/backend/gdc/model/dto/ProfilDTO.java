package org.backend.gdc.dto;

import lombok.Data;

@Data
public class ProfilDTO {

    private Long id;
    private String code;
    private String label;
    private String description;
    private boolean suspended;


}
