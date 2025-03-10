package com.yr.alquilercoches.controllers.wwwControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.services.ClienteService;

@Controller
public class RegisterController {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "www/Register/register";
    }

    @PostMapping("/register")
    public String registrarCliente(@ModelAttribute Clientes cliente) {
        // Debug original password
        String rawPassword = cliente.getPassword();
        System.out.println("Registering user with password length: " + rawPassword.length());
        
        // Encode password
        String encodedPassword = passwordEncoder.encode(rawPassword);
        cliente.setPassword(encodedPassword);
        cliente.setRole("ROLE_USER");
        
        System.out.println("Stored hash: " + encodedPassword);
        // Verify we can match it immediately
        boolean verifies = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Verification after encoding: " + verifies);
        
        clienteService.save(cliente);
        return "redirect:/login?registered";
    }
    }
