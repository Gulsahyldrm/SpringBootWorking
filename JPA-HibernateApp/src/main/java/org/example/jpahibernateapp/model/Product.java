package org.example.jpahibernateapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name ="products")
public class Product extends BaseEntity{
    @Id
    @Column(name = "product_ıd", length = 100, nullable = false)
    @GeneratedValue( generator = "product_gen", strategy = GenerationType.SEQUENCE) //GenerationType.TABLE (SEQUENCE nin desteklenmediği veri tabanlarında SEQUENCE yi simule eder) GenerationType.AUTO,  GenerationType.IDENTITY (ikisi de performans açısından pek tercih edilmez SEQUENCE the best)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1000, allocationSize = 1)
    private int id;
    @Column(name = "product_name", length = 200, nullable = true)
    private String name;
    @Column(name = "product_stock", length = 100, nullable = false)
    private String stock;
    @Column(name = "product_price", length = 100, nullable = false, precision =5, scale = 2)
    private BigDecimal price;
    @Column(name = "product_description", length = 100, nullable = false)
    private String description;


}
