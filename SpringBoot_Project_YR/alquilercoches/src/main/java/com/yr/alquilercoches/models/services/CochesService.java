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

    public List<Coches> getAll(){
        return cochesRepository.findAll();
    }

    public Coches findById(Long id){
        return cochesRepository.findById(id).orElse(null);
    }

    public Coches save(Coches coche){
        return cochesRepository.save(coche);
    }

    //update
    public Coches update(Coches coche){
        return cochesRepository.save(coche);
    }

    //delete
    public void delete(Coches coche){
        cochesRepository.delete(coche);
    }


    public void deleteById(Long id){
        cochesRepository.deleteById(id);
    }
    
    public Coches getId(Long id){
        Coches coche = cochesRepository.findById(id).get();
        System.out.println(coche);
        return coche;
    }
}
