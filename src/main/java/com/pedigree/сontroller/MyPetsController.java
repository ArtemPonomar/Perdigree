package com.pedigree.сontroller;

import com.pedigree.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPetsController {
    @Autowired
    private PetService petService;

    @GetMapping(value = "my_pets")
    public String myPets(Model model){
        model.addAttribute("pets", petService.findAll());
        return "my_pets";
    }
}
