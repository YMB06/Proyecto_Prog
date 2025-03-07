package com.yr.alquilercoches.controllers.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    
     @GetMapping("/admin")
    public String admin(){
        return "/admin/index";
    }
}
