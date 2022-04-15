package org.backend.gcmd.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PermissionDTO {
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
