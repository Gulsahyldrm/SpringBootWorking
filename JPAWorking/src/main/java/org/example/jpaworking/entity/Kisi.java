package org.example.jpaworking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kisi {
    @Id
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_kişi",allocationSize = 1)
    private Long id;
    @Column(length = 100, name = "adi")
    private String adi;
    @Column(length = 100, name = "soyadi")
    private String soyadi;
    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresleri;
}
