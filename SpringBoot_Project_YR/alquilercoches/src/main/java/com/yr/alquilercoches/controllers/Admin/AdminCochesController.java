package com.yr.alquilercoches.controllers.Admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.CochesService;

@Controller
public class AdminCochesController {
    @Autowired
    private CochesService cochesService;

    @GetMapping("/admin/coches")
    public String coches(Model model){
        List<Coches> coches = this.cochesService.getAll();
        model.addAttribute("LCoches", coches);
        return "admin/Coches"; // Changed to match exact template name
    }

    @GetMapping("/admin/coches/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("coche", new Coches());
        return "admin/crearCoches"; // Make sure this matches your template name exactly
    }
    
    @PostMapping("/admin/coches/crear")
    public String crearCoche(@ModelAttribute("coche") Coches coche, RedirectAttributes redirectAttributes) {
        try {
            cochesService.save(coche);
            redirectAttributes.addFlashAttribute("mensaje", "Coche creado exitosamente");
            return "redirect:/admin/coches";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al crear el coche: " + e.getMessage());
            return "redirect:/admin/coches/crear";
        }
    }

    @GetMapping("/admin/coches/editar/{id}")
public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
    try {
        Coches coche = cochesService.getId(id);
        model.addAttribute("coche", coche);
        return "admin/editarCoches";
    } catch (Exception e) {
        return "redirect:/admin/coches";
    }
}

@PostMapping("/admin/coches/editar/{id}")
public String editarCoche(@PathVariable Long id, @ModelAttribute Coches coche, RedirectAttributes redirectAttributes) {
    try {
        coche.setId(id);
        cochesService.update(coche);
        redirectAttributes.addFlashAttribute("mensaje", "Coche actualizado exitosamente");
        return "redirect:/admin/coches";
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("error", "Error al actualizar el coche: " + e.getMessage());
        return "redirect:/admin/coches/editar/" + id;
    }
}

}
