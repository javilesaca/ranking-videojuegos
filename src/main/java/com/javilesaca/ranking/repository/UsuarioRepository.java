package com.javilesaca.ranking.repository;

import com.javilesaca.ranking.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
