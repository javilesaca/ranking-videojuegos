package com.javilesaca.ranking.repository;

import com.javilesaca.ranking.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de repositorio para la gestión de usuarios en la base de datos.
 * @see Usuario
 * @author Javier Lesaca Medina
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
