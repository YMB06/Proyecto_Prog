package com.yr.alquilercoches.controllers.wwwControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.CochesService;
import com.yr.alquilercoches.models.repositories.CochesRepository;

@Controller
public class CochesController {
    
     @Autowired
    private CochesRepository cochesRepository;
    @GetMapping("/gamas/listar")
    public String home(Model model){
    
        List<Coches> coches
        = this.cochesService.getAll(); //
        coches.forEach(System.out::println);
        model.addAttribute("LCoches", coches);
        return "/www/coches";

}

@GetMapping("/gamas/{id}")
public String getGama( @PathVariable(value="id", required =false) String id, Model model){
    //Model model -> es un area de intercambio de datos entre el controlador y la vista, NO ES EL CONCEPTO DE MODELO
    //En la plantilla detalle.html tendremos el objeto "gama" que se ha pasado desde el controlador
    System.out.println("La gama es " +id);
    Gamas1 gama = this.GamasService.getId(id);
    System.out.println(gama);
     //
    //= this.GamasService.getId(id); //
    model.addAttribute("Lgamas", gama);
    return "/www/gamas/detalle";

}
}
