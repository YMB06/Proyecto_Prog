package com.yr.alquilercoches.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.repositories.ClienteRepository;

@Service
public class ClienteService  {
    
     @Autowired
    private ClienteRepository clienteRepository;

   // Use PasswordEncoder, not BCryptPasswordEncoder directly

   @Autowired
   private PasswordEncoder passwordEncoder;

   public Clientes save(Clientes cliente) {
    System.out.println("Saving user with username: " + cliente.getUsername());
    return clienteRepository.save(cliente); // Asume que la contraseña ya viene codificada.
}

    
     public List<Clientes> getAll(){
        return clienteRepository.findAll();
    }

    public Clientes findById(Long id){
        return clienteRepository.findById(id).orElse(null);
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

    public Clientes findByUsername(String user) {
        return clienteRepository.findByUsername(user).orElse(null);
    }

}
