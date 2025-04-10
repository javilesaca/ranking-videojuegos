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
/**
 * Controlador para gestionar los votos en el sistema.
 * Proporciona un endpoint para agregar votos.
 */
@RestController
@RequestMapping("/api/votos")
public class VotoController {

    /** Servicio para la gestión de votos. */
    @Autowired
    private VotoService votoService;

    /**
     * Agrega un nuevo voto al sistema.
     *
     * @param voto Objeto que representa el voto a registrar.
     * @return ResponseEntity con el voto agregado.
     */
    @PostMapping
    public ResponseEntity<Voto> agregarVoto(@RequestBody Voto voto) {
        return ResponseEntity.ok(votoService.guardar(voto));
    }
}
