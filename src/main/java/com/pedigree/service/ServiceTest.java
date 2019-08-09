package com.pedigree.service;

import com.pedigree.entity.ColorTest;
import com.pedigree.entity.PetTest;
import com.pedigree.repository.ColorRepo;
import com.pedigree.repository.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {
    @Autowired
    private ColorRepo colorRepo;

    @Autowired
    private PetRepo petRepo;

    public void saveColourTest(ColorTest colorTest){
        if (colorRepo.findAll() != null){
            for (ColorTest ct : colorRepo.findAll()){

            }
        }
    }

    public void savePet(PetTest pet){
        petRepo.save(pet);
    }
}
