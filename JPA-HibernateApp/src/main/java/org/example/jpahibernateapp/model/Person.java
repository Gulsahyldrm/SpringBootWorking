package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String email;
    private String phone;
    private LocalDate startDate;

    @OneToOne
    private IdentitiyCard identitiyCard;
    @OneToOne
    private Car vehicle;
}
