package com.yr.alquilercoches.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.repositories.CochesRepository;

import java.util.List;

@Service
public class CochesService {

    @Autowired
    CochesRepository cochesRepository;

    public List<Coches> findAll(){
        return cochesRepository.findAll();
    }

    public Coches findById(String id){
        return cochesRepository.findById(id).orElse(null);
    }

    public Coches save(Coches coche){
        return cochesRepository.save(coche);
    }

    public void deleteById(String id){
        cochesRepository.deleteById(id);
    }
    
}
