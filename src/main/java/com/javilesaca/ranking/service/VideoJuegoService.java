package com.javilesaca.ranking.service;

import com.javilesaca.ranking.model.Videojuego;
import com.javilesaca.ranking.repository.VideoJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoJuegoService {
    @Autowired
    private VideoJuegoRepository videoJuegoRepository;

    //Metodos
    public List<Videojuego> listarTodos() {
        return videoJuegoRepository.findAll();
    }

    public Optional<Videojuego> buscarPorId(Long id){
        return videoJuegoRepository.findById(id);
    }

    public Videojuego guardar(Videojuego videojuego){
        return videoJuegoRepository.save(videojuego);
    }

    public void eliminar(Long id){
        videoJuegoRepository.deleteById(id);
    }
}
