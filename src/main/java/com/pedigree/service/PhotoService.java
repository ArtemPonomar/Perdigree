package com.pedigree.service;

import com.pedigree.entity.pet_related.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PhotoService {
    @Autowired
    private PetService petService;

    public void savePhoto(Pet pet, File photo){

    }

}
