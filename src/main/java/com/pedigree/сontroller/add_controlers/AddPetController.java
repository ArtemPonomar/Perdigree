//package com.pedigree.сontroller.add_controlers;
//
//import com.pedigree.entity.PetFormParameters;
//import com.pedigree.service.BreederService;
//import com.pedigree.service.PetService;
//import com.pedigree.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.text.ParseException;
//
//@Controller
//public class AddPetController {
//    @Autowired
//    private ImageService imageService;
//
//    @Autowired
//    private PetService petService;
//
//    @Autowired
//    private BreederService breederService;
//
//    @RequestMapping(value = "/add/pet", method = RequestMethod.GET)
//    public String addPetForm(Model model, @ModelAttribute("errorMessage") String errorMessage, @ModelAttribute("successMessage") String successMessage){
//        Long id = petService.getBlank().getId();
//        PetFormParameters petFormParameters = petService.getPetFormParameters();
//        model.addAttribute("parameters", petFormParameters);
//        model.addAttribute("errorMessage", errorMessage);
//        model.addAttribute("successMessage", successMessage);
//        return "redirect:/edit_pet/" + id;
//    }
//
//    @PostMapping(value = "/add/pet")
//    public ModelAndView savePet(@RequestParam(required = false) String petName,
//                                @RequestParam(required = false) String birthDate,
//                                @RequestParam(required = false) Long speciesId,
//                                @RequestParam(required = false) String gender,
//                                @RequestParam(required = false) MultipartFile photo,
//                                @RequestParam(required = false) String metric,
//                                @RequestParam(required = false) Long breedId,
//                                @RequestParam(required = false) Long colorId,
//                                @RequestParam(required = false) Long breederId,
//                                @RequestParam(required = false) Long fatherId,
//                                @RequestParam(required = false) Long motherId,
//                                Model model,
//                                RedirectAttributes redirectAttributes){
//        try {
//            String successMessage = petService.savePetFromParameters(13l, petName, birthDate, speciesId, gender, photo, metric, breedId, colorId, breederId, fatherId, motherId);
//            redirectAttributes.addFlashAttribute("successMessage", successMessage);
//        } catch (IllegalArgumentException e){
//            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
//            redirectAttributes.addFlashAttribute("successMessage", "Питомец сохранён без фото.");
//        } catch (ParseException e){
//            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
//        } finally {
////            if (editedPet != null) return new ModelAndView("redirect:/edit_pet/" + editedPet);
//            return new ModelAndView("redirect:/add/pet");
//        }
//    }
//}
