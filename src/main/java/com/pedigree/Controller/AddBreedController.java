package com.pedigree.Controller;

import com.pedigree.entity.pet_related.Breed;
import com.pedigree.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddBreedController {
    @Autowired
    private BreedService breedService;

    @GetMapping(value = "/add_breed")
    public String addBreed(Model model){
        return "add_breed";
    }

    @PostMapping(value = "/add_breed")
    public ModelAndView saveBreed(@RequestParam(required = true) String breedName, Model model){
        breedService.saveBreed(new Breed(breedName));
        return new ModelAndView("redirect:/add_breed");
    }
}
