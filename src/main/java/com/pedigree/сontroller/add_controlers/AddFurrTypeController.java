package com.pedigree.сontroller.add_controlers;

import com.pedigree.entity.pet_related.FurType;
import com.pedigree.service.FurTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddFurrTypeController {
    @Autowired
    private FurTypeService furTypeService;

    @GetMapping(value = "/add/fur_type")
    public String addBreed(Model model){
        return "add/fur_type";
    }

    @PostMapping(value = "/add/fur_type")
    public ModelAndView saveBreed(@RequestParam(required = true) String furType, Model model){
        furTypeService.saveFurType(new FurType(furType));
        return new ModelAndView("redirect:/add/fur_type");
    }
}