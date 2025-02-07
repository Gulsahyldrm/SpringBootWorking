package org.example.jpaworking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
@Entity
@Table(name = "adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable {
    @Id
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1)
    private Long id;
    @Column(length = 100, name = "adres")
    private String adres;
    @Enumerated
    private AdresTip adresTip;
    @Column(name = "aktif")
    private Boolean aktif;
    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip{
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}
