package com.yr.alquilercoches.controllers.Admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.services.ClienteService;

@Controller
public class AdminClienteController {
    
    @Autowired
    private ClienteService clienteService;

     @GetMapping("/admin/clientes")
     public String clientes(Model model){
         List<Clientes> clientes
         = this.clienteService.getAll(); 
            model.addAttribute("LCliente", clientes);
            return "/admin/clientes";
}
}
