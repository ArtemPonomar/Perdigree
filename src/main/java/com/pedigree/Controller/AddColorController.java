package com.pedigree.Controller;

import com.pedigree.entity.pet_related.Color;
import com.pedigree.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddColorController {
    @Autowired
    private ColorService colorService;

    @GetMapping(value = "/add_color")
    public String addColor(Model model){
        return "add_color";
    }

    @PostMapping(value = "/add_color")
    public ModelAndView saveColor(@RequestParam(required = true) String colorName, Model model){
        colorService.saveColor(new Color(colorName));
        return new ModelAndView("redirect:/add_color");
    }
}
