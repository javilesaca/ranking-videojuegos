package com.javilesaca.ranking.controller;


import com.javilesaca.ranking.model.Voto;
import com.javilesaca.ranking.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<Voto> agregarVoto(@RequestBody Voto voto) {
        return ResponseEntity.ok(votoService.guardar(voto));
    }
}
