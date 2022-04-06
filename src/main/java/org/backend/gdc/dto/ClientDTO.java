package org.backend.gdc.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class ClientDTO {

    private Long id;

    private String name;

    private String email;

    private int phone;
    
}
