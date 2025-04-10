package com.javilesaca.ranking.controller;

import com.javilesaca.ranking.model.Usuario;
import com.javilesaca.ranking.repository.UsuarioRepository;
import com.javilesaca.ranking.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de la autenticación de usuarios.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Inicia sesión y devuelve un token JWT.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return Token JWT si la autenticación es exitosa.
     * @see JwtService#generateToken(String)
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        String token = jwtService.generateToken(username);
        return ResponseEntity.ok(token);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * @param usuario Datos del usuario a registrar.
     * @return Mensaje de éxito.
     * @see UsuarioRepository#save(Object)
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}
