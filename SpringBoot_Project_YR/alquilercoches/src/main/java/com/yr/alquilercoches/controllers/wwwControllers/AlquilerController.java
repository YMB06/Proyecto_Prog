package com.yr.alquilercoches.controllers.wwwControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.services.AlquilerService;


@Controller
public class AlquilerController {
    
     @Autowired
    private AlquilerService alquilerService;
    @GetMapping("/alquiler")
    public String home(Model model){
    
        List<Alquiler> alquileres
        = this.alquilerService.getAll(); //
        alquileres.forEach(System.out::println);
        model.addAttribute("LAlquiler", alquileres);
        return "/www/alquiler";

}

@GetMapping("/alquiler/{id}")
public String getAlquiler( @PathVariable(value="id", required =false) String id, Model model){
    //Model model -> es un area de intercambio de datos entre el controlador y la vista, NO ES EL CONCEPTO DE MODELO
    //En la plantilla detalle.html tendremos el objeto "gama" que se ha pasado desde el controlador
    System.out.println("El alquiler es " +id);
    Alquiler alquiler = this.alquilerService.getId(id);
    System.out.println(alquiler);
    //= this.GamasService.getId(id); //
    model.addAttribute("LAlquiler", alquiler);
    return "/www/alquiler/detalle";

}
}
