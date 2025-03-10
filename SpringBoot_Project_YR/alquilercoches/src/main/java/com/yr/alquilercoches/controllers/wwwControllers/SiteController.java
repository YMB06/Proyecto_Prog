package com.yr.alquilercoches.controllers.wwwControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yr.alquilercoches.models.entities.Coches;
import com.yr.alquilercoches.models.services.CochesService;

import org.springframework.ui.Model;

@Controller
public class SiteController {
    
    @Autowired
    private CochesService cochesService;
    
    @GetMapping("/")
    public String site(Model model){
        List<Coches> coches = cochesService.getAll();
        model.addAttribute("coches", coches);
        return "www/site/index";
    }
}