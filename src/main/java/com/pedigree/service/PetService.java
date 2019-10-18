package com.pedigree.service;

import com.pedigree.entity.PetFormParameters;
import com.pedigree.entity.pet_related.*;
import com.pedigree.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private BreederRepository breederRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    public void savePetFromParameters(String petName, String birthDate, Long speciesId, String gender, MultipartFile photo, String metric, Long breedId, Long colorId, Long breederId, Long fatherId, Long motherId) throws IllegalArgumentException{
        Pet newPet = new Pet();
        newPet.setName(petName);
        newPet.setBirthday(birthDate);
        newPet.setSpecies(speciesRepository.findById(speciesId).get());
        newPet.setGender(Gender.valueOf(gender));
        newPet.setMetricId(metric);
        newPet.setBreed(breedRepository.findById(breedId).get());
        newPet.setColor(colorRepository.findById(colorId).get());
        newPet.setBreeder(breederRepository.findById(breederId).get());
        newPet.setFather(petRepository.findById(fatherId).get());
        newPet.setMother(petRepository.findById(motherId).get());
        savePet(newPet);
        photoService.savePhoto(newPet, photo);
        savePet(newPet);
    }

    public PetFormParameters getPetFormParameters(){
        PetFormParameters parameters = new PetFormParameters();
        parameters.setBreeders(breederRepository.findAll());
        parameters.setBreeds(breedRepository.findAll());
        parameters.setColors(colorRepository.findAll());
        parameters.setSpecies(speciesRepository.findAll());
        parameters.setFemales(petRepository.findByGender(Gender.female));
        parameters.setMales(petRepository.findByGender(Gender.male));
        return parameters;
    }

    @Transactional
    public void savePet(Pet pet){
        List<Pet> temp = petRepository.findByNameAndBreeder(pet.getName(), pet.getBreeder());
        if (temp.size() != 0) {
            pet.setId(temp.get(0).getId());
        }

        if (pet.getMother() != null) savePet(pet.getMother());
        if (pet.getFather() != null) savePet(pet.getFather());

        if (pet.getMother() != null) pet.setMother(petRepository.findByNameAndBreeder(pet.getMother().getName(), pet.getMother().getBreeder()).get(0));
        if (pet.getFather() != null) pet.setFather(petRepository.findByNameAndBreeder(pet.getFather().getName(), pet.getFather().getBreeder()).get(0));

        if (speciesRepository.findBySpeciesNameIgnoreCase(pet.getSpecies().getSpeciesName()).size() == 0) speciesRepository.save(pet.getSpecies());
        if (colorRepository.findByColorNameIgnoreCase(pet.getColor().getColorName()).size() == 0) colorRepository.save(pet.getColor());
        if (breedRepository.findByBreedNameIgnoreCase(pet.getBreed().getBreedName()).size() == 0) breedRepository.save(pet.getBreed());
        if (breederRepository.findByKennelNameIgnoreCase(pet.getBreeder().getKennelName()).size() == 0) breederRepository.save(pet.getBreeder());

        pet.setSpecies(speciesRepository.findBySpeciesNameIgnoreCase(pet.getSpecies().getSpeciesName()).get(0));
        pet.setColor(colorRepository.findByColorNameIgnoreCase(pet.getColor().getColorName()).get(0));
        pet.setBreed(breedRepository.findByBreedNameIgnoreCase(pet.getBreed().getBreedName()).get(0));
        pet.setBreeder(breederRepository.findByKennelNameIgnoreCase(pet.getBreeder().getKennelName()).get(0));

        petRepository.save(pet);
    }



//    public Pet find(String petName, Breeder breeder){
//        if (petRepository.findByNameAndBreeder(petName, breeder) == null) return null;
//        return petRepository.findByNameAndBreeder(petName, breeder).get(0);
//    }
//
//    public void saveAll(Iterable<Pet> pets){
//        petRepository.saveAll(pets);
//    }
}
