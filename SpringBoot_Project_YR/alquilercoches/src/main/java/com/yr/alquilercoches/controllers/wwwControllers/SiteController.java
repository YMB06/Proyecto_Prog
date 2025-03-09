package com.yr.alquilercoches.controllers.wwwControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    
    @GetMapping("/")
    public String site(){
        return "www/site/index";
    }
    
}
