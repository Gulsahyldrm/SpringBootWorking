package org.example.modelmapperworking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "KULLANICILAR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_gen",initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ISIM",length = 100)
    private String firstName;
    @Column(name = "SOYISIM",length = 100)
    private String lastName;

}
