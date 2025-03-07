package com.yr.alquilercoches.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.repositories.AlquilerRepository;

@Service
public class AlquilerService {
    //Injecta todo el comportamiento del repositorio
    //GamasRepository en la propiedad gamasRep
    //de la clase GamasService
    @Autowired
    AlquilerRepository alquilerRepository;

    public List<Alquiler> getAll(){
        return this.alquilerRepository.findAll();
    }
    
    //create
    public Alquiler create(Alquiler alquiler){
        return this.alquilerRepository.save(alquiler);
    }

    //update
    public Alquiler update(Alquiler alquiler){
        return this.alquilerRepository.save(alquiler);
    }

    //delete
    public void delete(Alquiler alquiler){
        this.alquilerRepository.delete(alquiler);
    }

    //delete by id
    public void deleteById(String id){
        this.alquilerRepository.deleteById(id);
    }
    //getid
    public Alquiler getId(String id){
        Alquiler alquiler = this.alquilerRepository.findById(id).get();
        System.out.println(alquiler);
        return alquiler;
    }
    

}
