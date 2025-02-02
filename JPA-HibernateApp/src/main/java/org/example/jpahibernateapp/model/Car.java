package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int year;
    private int distance;

    @OneToOne(mappedBy = "vehicle" )
    private Person owner;

}
