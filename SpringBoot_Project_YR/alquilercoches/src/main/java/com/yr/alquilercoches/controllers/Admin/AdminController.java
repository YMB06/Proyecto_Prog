package com.yr.alquilercoches.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.services.AlquilerService;
import com.yr.alquilercoches.models.services.CochesService;

import java.math.BigDecimal;

@Controller
public class AdminController {
    
    @Autowired
    private CochesService cochesService;

    @Autowired
    private AlquilerService alquilerService;

    @GetMapping({"/admin", "/admin/index"})  // Handle both URLs
    public String admin(Model model) {
        int totalCoches = cochesService.getAll().size();
        int totalAlquileres = alquilerService.getAll().size();
        int totalClientes = alquilerService.getAll().size();
        BigDecimal totalIngresos = alquilerService.getAll().stream()
                .map(Alquiler::getPrecio_total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalcoches", totalCoches);
        model.addAttribute("totalAlquileres", totalAlquileres);
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("totalIngresos", totalIngresos);

        return "admin/index";  // Remove the leading slash
    }
}