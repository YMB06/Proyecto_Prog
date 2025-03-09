package com.yr.alquilercoches.controllers.wwwControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.CochesService;

@Controller
public class CochesController {

         @Autowired
    private CochesService cochesService;
    @GetMapping("/coches")
    public String alquiler(Model model){
        List<Coches> coches
        = this.cochesService.getAll(); //
        coches.forEach(System.out::println);
        model.addAttribute("LCoche", coches);
        return "/www/coches/index";
}

@GetMapping("/coches/{id}")
public String getAlquiler( @PathVariable(value="id", required =false) Long id, Model model){
    System.out.println("El coche es " +id);
    Coches coche = this.cochesService.getId(id);
    System.out.println(coche);
    //= this.GamasService.getId(id); //
    model.addAttribute("LCoche", coche);
    return "/www/coche/detalle";
}
}
