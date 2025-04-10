package com.javilesaca.ranking.repository;

import com.javilesaca.ranking.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para la gestión de votos en la base de datos.
 * @see Voto
 * @author Javier Lesaca Medina
 */
public interface VotoRepository extends JpaRepository<Voto, Long> {

}
