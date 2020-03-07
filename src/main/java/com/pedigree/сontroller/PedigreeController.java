package com.pedigree.сontroller;

import com.pedigree.entity.pet_related.Pet;
import com.pedigree.service.PedigreeService;
import com.pedigree.service.PetService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PedigreeController {

    @Autowired
    PetService petService;

    @Autowired
    PedigreeService pedigreeService;

    @GetMapping(value = "/pedigree")
    public String getPedigree(
            @RequestParam(required = false) Long petId,
            Model model) {
        Pet pet = petService.preparePetForPedigree(petService.findById(petId), 4);
        model.addAttribute("pet", petService.preparePetForPedigree(petService.findById(petId), 4));
        model.addAttribute("creationDate", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
        return "pedigree";
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] download(
            @RequestParam(required = true) Long petId,
            HttpServletResponse response) {
        try {
            pedigreeService.downloadPedigree(petId);
            InputStream is = new URL("http://localhost:8080/pedigree?petId=" + petId).openStream();
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            return IOUtils.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
