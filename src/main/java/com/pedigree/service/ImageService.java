package com.pedigree.service;

import com.pedigree.entity.pet_related.Pet;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageService {

    private File petImageFolder;

    public ImageService() {
        String petImageFolderPath = "src" + File.separator + "main" + File.separator + "resources"  + File.separator + "static"+ File.separator + "petImages";

        petImageFolder = new File(petImageFolderPath);
        if (!petImageFolder.exists()) petImageFolder.mkdir();
    }

    public void saveOrUpdateImage(Pet pet, MultipartFile photo) throws IllegalArgumentException{
        if (photo.isEmpty()) return;
        if (photo.getContentType().contains("image")){
            if (pet.getImagePath() != null){
                deleteImage(pet.getImagePath());
            }
            String petPictureFilepath = petImageFolder.getPath() + File.separator + pet.getId() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            File f = new File(petPictureFilepath);

            try (FileOutputStream fos = new FileOutputStream(f)) {
                byte[] imageByte = photo.getBytes();
                fos.write(imageByte);
            } catch (Exception e) {
            }
            pet.setImagePath(petPictureFilepath);
        } else {
            throw new IllegalArgumentException("Фото не было сохранено");
        }
    }

    public String formatImageToFitBorders(int borderWidth, int borderHeight, String imagePath){
        try {
            BufferedImage bimg = ImageIO.read(new File(imagePath));
            int width = bimg.getWidth();
            int height = bimg.getHeight();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void deleteImage(String path) {
        File file = new File(path);
        file.delete();
    }
}
