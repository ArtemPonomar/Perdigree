package com.pedigree.service;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.pet_related.Breed;
import com.pedigree.entity.pet_related.Color;
import com.pedigree.entity.pet_related.Pet;
import com.pedigree.repository.BreedRepository;
import com.pedigree.repository.ColorRepository;
import com.pedigree.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private ColorRepository colorRepository;

    public List<Pet> getPets(){
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : petRepository.findAll()){
            pets.add(pet);
        }
        return pets;
    }

    public void saveOrUpdate(Pet pet){
        Pet temp = petRepository.findByNameAndBreeder(pet.getName(), pet.getBreeder());
        if (temp != null) {
            petRepository.delete(temp);
        }
        savePet(pet);

        petRepository.save(pet);
    }

    private void savePet(Pet pet){
        saveBreed(pet);
        saveColor(pet);
    }

    private void saveBreed(Pet pet){
        Breed breedFromRepo = breedRepository.findByBreed(pet.getBreed().getBreed());
        if (breedFromRepo == null) breedRepository.save(pet.getBreed());
        pet.setBreed(breedFromRepo);
    }

    private void saveColor(Pet pet){
        Color colorFromRepo = colorRepository.findByColor(pet.getColor().getColor());
        if (colorFromRepo == null) colorRepository.save(pet.getColor());
        pet.setColor(colorRepository.findByColor(pet.getColor().getColor()));
    }

    private void saveSpecies(Pet pet){

    }

    public Pet find(String petName, Breeder breeder){
        return petRepository.findByNameAndBreeder(petName, breeder);
    }

    public void save(Iterable<Pet> pets){
        petRepository.saveAll(pets);
    }
}
