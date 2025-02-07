package org.example.jpaworking.controller;

import lombok.AllArgsConstructor;
import org.example.jpaworking.dto.KisiDto;
import org.example.jpaworking.entity.Kisi;
import org.example.jpaworking.service.KisiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@AllArgsConstructor
public class KisiController {

    private final KisiService kisiService;

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }

    @GetMapping
    public ResponseEntity<List<KisiDto>>tumunuListele(){
        return ResponseEntity.ok(kisiService.getAll());
    }
}
