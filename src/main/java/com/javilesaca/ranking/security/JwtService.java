package com.javilesaca.ranking.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.Keys;


import java.security.Key;
import java.util.Date;

/**
 * Servicio para la generación y validación de tokens JWT.
 */
public class JwtService {

    /** Clave secreta utilizada para firmar los tokens JWT. */
    private static final String SECRET_KEY = "supersecretkeyforsigningjwt12345678901234567890123456789012";

    /** Tiempo de expiración del token en milisegundos (1 día). */
    private static final long EXPIRATION_TIME = 86400000; // 1 día


    /**
     * Genera un token JWT para un usuario dado.
     *
     * @param username Nombre de usuario para el que se generará el token.
     * @return Token JWT generado.
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), MacAlgorithm())
                .compact();
    }

    /**
     * Extrae el nombre de usuario de un token JWT.
     *
     * @param token Token JWT del cual se extraerá el usuario.
     * @return Nombre de usuario contenido en el token.
     */
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    /**
     * Obtiene la clave de firma utilizada para firmar y verificar los tokens JWT.
     *
     * @return Clave de firma en formato Key.
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
