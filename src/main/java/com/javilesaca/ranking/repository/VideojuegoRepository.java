package com.javilesaca.ranking.repository;

import com.javilesaca.ranking.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para la gestión de videojuegos en la base de datos.
 * @see Videojuego
 * @author Javier Lesaca Medina
 */
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {

}
