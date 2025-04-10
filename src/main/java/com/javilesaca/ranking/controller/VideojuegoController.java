package com.javilesaca.ranking.controller;


import com.javilesaca.ranking.model.Videojuego;
import com.javilesaca.ranking.repository.VideojuegoRepository;
import com.javilesaca.ranking.repository.VotoRepository;
import com.javilesaca.ranking.scraping.WebScrapingService;
import com.javilesaca.ranking.service.VideoJuegoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar videojuegos.
 * Proporciona endpoints para listar, agregar y eliminar videojuegos.
 */
@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    /** Servicio para la gestión de videojuegos. */
    private final VideoJuegoService videojuegoService;
    /** Servicio para realizar web scraping relacionado con videojuegos. */
    private final WebScrapingService webScrapingService;
    /** Repositorio para gestionar los votos de los videojuegos. */
    private final VotoRepository votoRepository;

    /**
     * Constructor del controlador de videojuegos.
     *
     * @param videoJuegoService Servicio para gestionar videojuegos.
     * @param votoRepository Repositorio para manejar los votos de los videojuegos.
     * @param webScrapingService Servicio para realizar web scraping.
     */
    public VideojuegoController(VideoJuegoService videoJuegoService, VotoRepository votoRepository , WebScrapingService webScrapingService) {
        this.videojuegoService = videoJuegoService;
        this.votoRepository = votoRepository;
        this.webScrapingService = webScrapingService;
    }

    /**
     * Obtiene la lista de videojuegos disponibles.
     *
     * @return Lista de videojuegos.
     * @see VideojuegoRepository#findAll()
     */
    @GetMapping
    public List<Videojuego> listarVideojuegos(){
        return videojuegoService.listarTodos();
    }

    /**
     * Agrega un nuevo videojuego al sistema.
     *
     * @param v Videojuego a agregar.
     * @return ResponseEntity con el videojuego agregado.
     */
    @PostMapping
    public ResponseEntity<Videojuego> agregarVideojuego(@RequestBody Videojuego v) {
        return ResponseEntity.ok(videojuegoService.guardar(v));
    }

    /**
     * Elimina un videojuego del sistema por su ID.
     *
     * @param id Identificador del videojuego a eliminar.
     * @return ResponseEntity con mensaje de confirmación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVideojuego(@PathVariable Long id) {
        videojuegoService.eliminar(id);
        return ResponseEntity.ok("Videojuego eliminado");
    }
}
