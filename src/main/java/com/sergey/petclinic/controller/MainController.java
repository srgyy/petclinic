package com.sergey.petclinic.controller;

import com.sergey.petclinic.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Sergey Borodkin
 */
@Controller
public class MainController {

    @Autowired
    VeterinarianService veterinarianService;

    @GetMapping
    public String home(Model model){
        return "home";
    }

    @GetMapping("/vets")
    public String vets(Model model){
        model.addAttribute("vets", veterinarianService.getAllVets());
        return "vets";
    }
}
