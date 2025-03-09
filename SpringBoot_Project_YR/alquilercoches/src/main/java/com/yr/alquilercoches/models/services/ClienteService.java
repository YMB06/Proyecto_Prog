package com.yr.alquilercoches.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.repositories.ClienteRepository;

@Service
public class ClienteService  {
    
    @Autowired
    ClienteRepository clienteRepository;

     public List<Clientes> getAll(){
        return clienteRepository.findAll();
    }

    public Clientes findById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Clientes save(Clientes cliente){
        return clienteRepository.save(cliente);
    }

    //update
    public Clientes update(Clientes cliente){
        return clienteRepository.save(cliente);
    }

    //delete
    public void delete(Clientes cliente){
        clienteRepository.delete(cliente);
    }


    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    public Clientes getId(Long id){
        Clientes cliente = clienteRepository.findById(id).get();
        System.out.println(cliente);
        return cliente;
    }

}
