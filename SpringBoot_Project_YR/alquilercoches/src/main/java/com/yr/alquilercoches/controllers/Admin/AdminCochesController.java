package com.yr.alquilercoches.controllers.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.CochesService;

@Controller
public class AdminCochesController {
             @Autowired
    private CochesService cochesService;
    @GetMapping("/admin/coches")
    public String alquiler(Model model){
        List<Coches> coches
        = this.cochesService.getAll(); //
        coches.forEach(System.out::println);
        model.addAttribute("LCoches", coches);
        return "/admin/coches";
}
}
