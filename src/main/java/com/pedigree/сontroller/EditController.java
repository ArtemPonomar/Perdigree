package com.pedigree.сontroller;

import com.pedigree.entity.pet_related.Pet;
import com.pedigree.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;

@Controller
public class EditController {

    @Autowired
    private PetService petService;

    @GetMapping(value = "/edit_pet")
    public String createAndEdit(Model model) {
//        Pet blank = petService.getBlank();
        model.addAttribute("pet", new Pet());
        model.addAttribute("parameters", petService.getPetFormParameters());
        return "edit_pet";
    }

    @GetMapping(value = "/edit_pet/{id}")
    public String editPage(@PathVariable("id") Long id,
                           @ModelAttribute("errorMessage") String errorMessage,
                           @ModelAttribute("successMessage") String successMessage,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        model.addAttribute("pet", petService.findById(id));
        model.addAttribute("parameters", petService.getPetFormParameters(id));
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("successMessage", successMessage);
        return "edit_pet";
    }

    @PostMapping(value = "/save")
    public ModelAndView savePet(
            @RequestParam(required = false) Long petId,
            @RequestParam(required = false) String pedigreeId,
            @RequestParam(required = false) String petName,
            @RequestParam(required = false) String birthDate,
            @RequestParam(required = false) Long speciesId,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) MultipartFile photo,
            @RequestParam(required = false) String metric,
            @RequestParam(required = false) Long breedId,
            @RequestParam(required = false) Long furTypeId,
            @RequestParam(required = false) Long colorId,
            @RequestParam(required = false) Long breederId,
            @RequestParam(required = false) Long fatherId,
            @RequestParam(required = false) Long motherId,
            Model model,
            RedirectAttributes redirectAttributes) {
        try {
            String successMessage = petService.savePetFromParameters(petId, pedigreeId, petName, birthDate, speciesId, gender, photo, metric, breedId, furTypeId, colorId, breederId, fatherId, motherId);
            redirectAttributes.addFlashAttribute("successMessage", successMessage);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } catch (ParseException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } finally {
            return new ModelAndView("redirect:/my_pets");
        }
    }
}
