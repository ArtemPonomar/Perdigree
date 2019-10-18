package com.pedigree.Controller;

import com.pedigree.entity.PetFormParameters;
import com.pedigree.service.BreederService;
import com.pedigree.service.PetService;
import com.pedigree.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;

@Controller
public class MeshController {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private PetService petService;

    @Autowired
    private BreederService breederService;

    @RequestMapping(value = "/pedigree")
    public String myPets(Model model){
        return "pedigree";
    }

    @RequestMapping(value = "/add_pet", method = RequestMethod.GET)
    public String addPetForm(Model model){
        PetFormParameters petFormParameters = petService.getPetFormParameters();
        model.addAttribute("parameters", petFormParameters);
        return "add_pet";
    }

    @RequestMapping(value = "/add_pet", method = RequestMethod.POST)
    public ModelAndView savePet(@RequestParam String petName,
                                @RequestParam String birthDate,
                                @RequestParam Long speciesId,
                                @RequestParam String gender,
                                @RequestParam(required = false) MultipartFile photo,
                                @RequestParam(required = false) String metric,
                                @RequestParam Long breedId,
                                @RequestParam Long colorId,
                                @RequestParam Long breederId,
                                @RequestParam(required = false) Long fatherId,
                                @RequestParam(required = false) Long motherId,
                                Model model){
        System.out.println("test");
        try {
            petService.savePetFromParameters(petName, birthDate, speciesId, gender, photo, metric, breedId, colorId, breederId, fatherId, motherId);
        } catch (IllegalArgumentException e){

        }
        return new ModelAndView("redirect:/add_pet");
    }
}
