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
        return "www/register/register";
    }

    @PostMapping("/register")
    public String registrarCliente(@ModelAttribute Clientes cliente) {
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        cliente.setRole("ROLE_USER");
        clienteService.save(cliente);
        return "redirect:/login?registered";
    }
}