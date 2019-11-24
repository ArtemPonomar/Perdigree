package com.pedigree.сontroller.add_controlers;

import com.pedigree.entity.Breeder;
import com.pedigree.service.BreederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddBreederController {
    @Autowired
    private BreederService breederService;

    @GetMapping(value = "/add/breeder")
    public String addBreeder(Model model){
        return "add/breeder";
    }

    @PostMapping(value = "/add/breeder")
    public ModelAndView saveBreeder(@RequestParam String breederName,
                              @RequestParam String breederEmail,
                              @RequestParam String kennelName,
                              @RequestParam String breederNumber,
                              @RequestParam(required = false) String breederSite,
                              Model model){
        Breeder breeder = new Breeder();
        breeder.setBreederName(breederName);
        breeder.setEmail(breederEmail);
        breeder.setKennelName(kennelName);
        breeder.setPhoneNumber(breederNumber);
        if(!breederSite.isEmpty())breeder.setSiteAddress(breederSite);
        breederService.save(breeder);
        return new ModelAndView("redirect:/add/breeder");
    }
}
