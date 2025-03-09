package com.yr.alquilercoches.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.entities.CustomUserDetails;
import com.yr.alquilercoches.models.repositories.ClienteRepository;

@Service
public class ClienteUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Clientes cliente = clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
            
            // Add detailed logging
            System.out.println("=== User Authentication Attempt ===");
            System.out.println("Username: " + cliente.getUsername());
            System.out.println("Role: " + cliente.getRole());
            System.out.println("Password Hash: " + cliente.getPassword());
            System.out.println("==============================");
            
            return new CustomUserDetails(cliente);
        } catch (Exception e) {
            System.err.println("Error during authentication: " + e.getMessage());
            e.printStackTrace();
            throw new UsernameNotFoundException("Authentication failed", e);
        }
    }
}
