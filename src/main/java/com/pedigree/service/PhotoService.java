package com.pedigree.service;

import com.pedigree.entity.pet_related.Pet;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PhotoService {
    @Autowired
    private PetService petService;

    private File petImageFolder;

    public PhotoService() {
        String petImageFolderPath = "petImages";

        petImageFolder = new File(petImageFolderPath);
        if (!petImageFolder.exists()) petImageFolder.mkdir();
    }

    public void savePhoto(Pet pet, MultipartFile photo) throws IllegalArgumentException{
        if (photo.getContentType().contains("image")) {
            String petPictureFilepath = petImageFolder.getName() + File.separator + pet.getId() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            System.out.println(petPictureFilepath);
            File f = new File(petPictureFilepath);
            System.out.println(petPictureFilepath);
            try (FileOutputStream fos = new FileOutputStream(f)) {
                byte[] imageByte = photo.getBytes();
                fos.write(imageByte);
            } catch (Exception e) {
            }
            pet.setImagePath(f.getAbsolutePath());
        } else {
            throw new IllegalArgumentException("chosen file is not an image.");
        }
    }

}
