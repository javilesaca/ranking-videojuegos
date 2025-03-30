package com.javilesaca.ranking.controller;


import com.javilesaca.ranking.model.Videojuego;
import com.javilesaca.ranking.service.VideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideoJuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> listarVideojuegos(){
        return videojuegoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Videojuego> agregarVideojuego(@RequestBody Videojuego v) {
        return ResponseEntity.ok(videojuegoService.guardar(v));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVideojuego(@PathVariable Long id) {
        videojuegoService.eliminar(id);
        return ResponseEntity.ok("Videojuego eliminado");
    }
}
