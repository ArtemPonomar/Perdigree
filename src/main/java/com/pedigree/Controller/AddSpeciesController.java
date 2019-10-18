package com.pedigree.Controller;

import com.pedigree.entity.pet_related.Species;
import com.pedigree.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddSpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping(value = "/add_species")
    public String addSpecies(Model model){
        return "add_species";
    }

    @PostMapping(value = "/add_species")
    public ModelAndView saveSpecies(@RequestParam(required = true) String speciesName, Model model){
        speciesService.saveSpecies(new Species(speciesName));
        return new ModelAndView("redirect:/add_species");
    }
}
