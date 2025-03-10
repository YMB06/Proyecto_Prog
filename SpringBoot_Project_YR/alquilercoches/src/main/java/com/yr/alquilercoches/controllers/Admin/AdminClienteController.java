package com.yr.alquilercoches.controllers.Admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.entities.Clientes;
import com.yr.alquilercoches.models.services.AlquilerService;
import com.yr.alquilercoches.models.services.ClienteService;

@Controller
public class AdminClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin/clientes")
    public String clientes(Model model) {
        List<Clientes> clientes = clienteService.getAll();
        model.addAttribute("LCliente", clientes);
        return "admin/Clientes";  // Make sure this matches your template name exactly
    }
    @GetMapping("/admin/clientes/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "admin/crearClientes";
    }
    
    @PostMapping("/admin/clientes/crear")
    public String crearCliente(@ModelAttribute Clientes cliente, RedirectAttributes redirectAttributes) {
        try {
            cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
            clienteService.save(cliente);
            redirectAttributes.addFlashAttribute("mensaje", "Cliente creado exitosamente");
            return "redirect:/admin/clientes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al crear el cliente: " + e.getMessage());
            return "redirect:/admin/clientes/crear";
        }
    }
    @GetMapping("/admin/clientes/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        try {
            Clientes cliente = clienteService.getId(id);
            if (cliente == null) {
                return "redirect:/admin/clientes";
            }
            model.addAttribute("cliente", cliente);
            return "admin/editarClientes"; // Note: matches your template name
        } catch (Exception e) {
            return "redirect:/admin/clientes";
        }
    }

    @PostMapping("/admin/clientes/editar/{id}")
    public String editarCliente(@PathVariable Long id, @ModelAttribute Clientes cliente, RedirectAttributes redirectAttributes) {
        try {
            Clientes existingCliente = clienteService.getId(id);
            cliente.setId(id);
            
            // Only update password if a new one is provided
            if (cliente.getPassword() == null || cliente.getPassword().isEmpty()) {
                cliente.setPassword(existingCliente.getPassword());
            } else {
                cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
            }
            
            clienteService.update(cliente);
            redirectAttributes.addFlashAttribute("mensaje", "Cliente actualizado exitosamente");
            return "redirect:/admin/clientes";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el cliente: " + e.getMessage());
            return "redirect:/admin/clientes/editar/" + id;
        }
    }

    @Autowired
private AlquilerService alquilerService; // Add this at the top with other autowired services

@PostMapping("/admin/clientes/borrar/{id}")
public String borrarCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    try {
        Clientes cliente = clienteService.getId(id);
        if (cliente != null) {
            // First delete all associated rentals
            List<Alquiler> alquileresAsociados = alquilerService.findByClienteId(id);
            for (Alquiler alquiler : alquileresAsociados) {
                alquilerService.deleteById(alquiler.getId());
            }
            
            // Then delete the client
            clienteService.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Cliente y sus alquileres asociados eliminados exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("error", "Cliente no encontrado");
        }
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("error", "Error al eliminar el cliente: " + e.getMessage());
    }
    return "redirect:/admin/clientes";
}
}