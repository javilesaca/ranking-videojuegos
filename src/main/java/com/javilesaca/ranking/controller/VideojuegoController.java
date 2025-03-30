package com.javilesaca.ranking.controller;


import com.javilesaca.ranking.model.Videojuego;
import com.javilesaca.ranking.scraping.WebScrapingService;
import com.javilesaca.ranking.service.VideoJuegoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    private final VideoJuegoService videojuegoService;
    private final WebScrapingService webScrapingService;

    public VideojuegoController(VideoJuegoService videoJuegoService, WebScrapingService webScrapingService) {
        this.videojuegoService = videoJuegoService;
        this.webScrapingService = webScrapingService;
    }

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
