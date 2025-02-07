package org.example.jpaworking.dto;

import lombok.Data;
import org.example.jpaworking.entity.Adres;

import java.util.List;
@Data
public class KisiDto {
    private Long id;
    private String adi;
    private String soyadi;
    private List<String> adresler;
}
