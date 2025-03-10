package com.yr.alquilercoches.controllers.Admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.AlquilerService;
import com.yr.alquilercoches.models.services.CochesService;
import com.yr.alquilercoches.models.services.ClienteService;

@Controller
public class AdminAlquilerController {
    @Autowired
    private AlquilerService alquilerService;
    
    @Autowired
    private CochesService cochesService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/admin/alquileres")
    public String alquiler(Model model) {
        List<Alquiler> alquileres = this.alquilerService.getAll();
        model.addAttribute("LAlquiler", alquileres);
        return "admin/alquileres"; // Remove leading slash
    }

    @GetMapping("/admin/alquileres/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("alquiler", new Alquiler());
        List<Coches> coches = cochesService.getAll();
        List<Clientes> clientes = clienteService.getAll(); // Add this line
        model.addAttribute("coches", coches);
        model.addAttribute("clientes", clientes); // Add this line
        return "admin/crearAlquileres";
    }
    
    @PostMapping("/admin/alquileres/crear")
    public String crearAlquiler(@ModelAttribute Alquiler alquiler, RedirectAttributes redirectAttributes) {
        try {
            alquilerService.create(alquiler);
            redirectAttributes.addFlashAttribute("mensaje", "Alquiler creado exitosamente");
            return "redirect:/admin/alquileres";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al crear el alquiler: " + e.getMessage());
            return "redirect:/admin/alquileres/crear"; // Updated redirect path
        }
    }
}



