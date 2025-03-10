package com.yr.alquilercoches.controllers.wwwControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/cliente/index")
    public String clienteIndex(Model model) {
        return "cliente/index"; // Create this view in templates/cliente/index.html
    }
}
