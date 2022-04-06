package org.backend.gdc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private Date datecreation;
    private String email;
    private String firstname;
    private String lastname;
    private int phone;
    private int matriculation;
    private String password;
}
