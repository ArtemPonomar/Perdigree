package com.pedigree.service;

import com.pedigree.entity.pet_related.Pet;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

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

//    public String formatImageToFitBorders(int borderWidth, int borderHeight, String imagePath){
//        try {
//            BufferedImage bimg = ImageIO.read(new File(imagePath));
//            int width = bimg.getWidth();
//            int height = bimg.getHeight();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

    public static String fileToBase64(File file){
        String encodedfile = "data:image;base64, ";
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile += new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedfile;
    }

    public void deleteImage(String path) {
        File file = new File(path);
        file.delete();
    }
}
