package com.pedigree.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public ModelAndView index(Model model){
        return new ModelAndView("redirect:/my_pets");
    }

    @GetMapping(value = "/add/test")
    public String test(Model model){
        return "/add/test.html";
    }
}
