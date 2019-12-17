package com.pedigree.сontroller;

import com.pedigree.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PedigreeController {

    @Autowired
    PetService petService;

    @GetMapping(value = "/pedigree")
    public String getPedigree(
            @RequestParam(required = false) Long petId,
            Model model){
        model.addAttribute("pet", petService.findById(petId));
        return "pedigree";
    }
}
