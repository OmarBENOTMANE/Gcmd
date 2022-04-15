package org.backend.gcmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "boncommandes")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommandeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero_bc;

    private String navire;

    private String consignataire;

    private Date date_amarage;

    private Date date_desamarage;

    private int lht;

    private double jauge_brute;

    private String poste;

    private String capitaine;

    private int numero_escale;

    private int mumero_credit;

    private int mumero_commande;

    private int connaissement;

    private int bulletin_reception;
}