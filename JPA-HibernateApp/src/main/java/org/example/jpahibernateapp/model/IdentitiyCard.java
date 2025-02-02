package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class IdentitiyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String givenName;
    private String surname;
    private String identityNo;
    private char gender;
    private LocalDate birthDate;

    @OneToOne(mappedBy = "identitiyCard" )
    private Person person;


}
