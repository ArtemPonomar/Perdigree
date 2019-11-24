package com.pedigree.сontroller;

import com.pedigree.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class ImageController {

    @Autowired
    private PetService petService;

    private ResourceLoader resourceLoader  = new DefaultResourceLoader();

    @GetMapping(value = "/petImage/{id}", produces = {"image/png", "image/jpeg", "image/gif"})
    public @ResponseBody byte[] showImage(@PathVariable Long id){
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(Paths.get(petService.getImagePathById(id)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @PostMapping(value = "/delete_image/{id}")
    public String delete(@PathVariable long id){
        petService.deleteImageByPetId(id);
        return "redirect:/edit_pet/" + id;
    }
}
