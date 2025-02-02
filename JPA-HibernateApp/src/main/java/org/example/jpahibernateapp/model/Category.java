package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name ="category")
public class Category extends BaseEntity{
    @Id
    @Column(name = "category_Id", length = 100, nullable = false)
    @GeneratedValue( generator = "category_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_gen",sequenceName = "category_seq",initialValue = 1000, allocationSize = 1)
    private int id;
    @Column(name = "category_name", length = 100, nullable = false)
    private String name;

}
