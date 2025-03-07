package com.yr.alquilercoches.controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.services.AlquilerService;

@Controller
public class AdminAlquilerController {
         @Autowired
    private AlquilerService alquilerService;
    @GetMapping("/admin/alquileres")
    public String alquiler(Model model){
    
        List<Alquiler> alquileres
        = this.alquilerService.getAll(); //
        alquileres.forEach(System.out::println);
        model.addAttribute("LAlquiler", alquileres);
        return "/admin/alquileres";

}
}

