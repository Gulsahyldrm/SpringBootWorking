package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

import java.util.Date;

//bu class diğer classlardaki field tekrarını ortadan kaldırır ve bunu hibrnate in @MappedSuperclass anatosyonu ile yapar,
//bu clasın db de bir tablosu tutulmaz ve bu sınıf bir entity olarak kabul edilmez!
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)//DB de tarih tutar
    private Date createDate;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIME)//DB de saat olarak tutar TIMESTAMP tarih ve saati birlikte tutar
    private Date modifiedDate;

    @Enumerated(EnumType.STRING)
    private Rating ratingOrginal = Rating.STANDART;
    @Enumerated(EnumType.ORDINAL) //DB de 0 veya 1 tutulur
    private  Rating ratingStr = Rating.PREMIUM;
}

enum Rating {
    STANDART, PREMIUM
}