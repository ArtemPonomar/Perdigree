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
    public String savePet(@RequestParam(required = false) String petName,
                          @RequestParam(required = false) String birthDate,
                          @RequestParam(required = false) Long speciesId,
                          @RequestParam(required = false) String gender,
                          @RequestParam(required = false) File photo,
                          @RequestParam(required = false) String metric,
                          @RequestParam(required = false) Long breedId,
                          @RequestParam(required = false) Long colorId,
                          @RequestParam(required = false) Long breederId,
                          @RequestParam(required = false) Long fatherId,
                          @RequestParam(required = false) Long motherId,
                          Model model){
        System.out.println("test");
        petService.savePetFromParameters(petName, birthDate, speciesId, gender, photo, metric, breedId, colorId, breederId, fatherId, motherId);

        PetFormParameters petFormParameters = petService.getPetFormParameters();
        model.addAttribute("parameters", petFormParameters);
        return "add_pet";
    }

    @RequestMapping(value = "/add_breeder", method = RequestMethod.GET)
    public String addBreeder(Model model){
        return "add_breeder";
    }

    @RequestMapping(value = "/add_breeder", method = RequestMethod.POST)
    public String saveBreeder(Model model){
        return "add_breeder";
    }
}
