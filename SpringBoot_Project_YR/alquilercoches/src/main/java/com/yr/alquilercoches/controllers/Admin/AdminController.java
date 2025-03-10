package com.yr.alquilercoches.controllers.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.services.AlquilerService;
import com.yr.alquilercoches.models.services.ClienteService;
import com.yr.alquilercoches.models.services.CochesService;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class AdminController {
    
    @Autowired
    private CochesService cochesService;

    @Autowired
    private AlquilerService alquilerService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping({"/admin", "/admin/index"})  // Handle both URLs
    public String admin(Model model) {
        int totalCoches = cochesService.getAll().size();
        int totalAlquileres = alquilerService.getAll().size();
        int totalClientes = clienteService.getAll().size();
        BigDecimal totalIngresos = alquilerService.getAll().stream()
                .map(Alquiler::getPrecio_total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalcoches", totalCoches);
        model.addAttribute("totalAlquileres", totalAlquileres);
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("totalIngresos", totalIngresos);
        //10 ultimos alquileres añadidos
        List<Alquiler> ultimosAlquileres = alquilerService.getUltimosAlquileres(10);
        model.addAttribute("ultimosAlquileres", ultimosAlquileres);

        return "admin/index";  
    }
}