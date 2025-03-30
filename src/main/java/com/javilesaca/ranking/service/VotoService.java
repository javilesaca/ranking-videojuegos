package com.javilesaca.ranking.service;

import com.javilesaca.ranking.model.Voto;
import com.javilesaca.ranking.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    private VotoRepository votoRepository;

    public Voto guardar (Voto voto){
        return votoRepository.save(voto);
    }
}
