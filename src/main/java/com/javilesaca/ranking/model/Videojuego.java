package com.javilesaca.ranking.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String plataforma;
    private double puntuacion;

    @OneToMany(mappedBy ="videojuego", cascade = CascadeType.ALL)
    private List<Voto> votos;

    //Getters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }
}
