package com.pedigree.service;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.PetFormParameters;
import com.pedigree.entity.pet_related.*;
import com.pedigree.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private DateService dateService;

    @Autowired
    private ImageService imageService;

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

    @Autowired
    private FurTypeRepository furTypeRepository;

    @Transactional
    public String savePetFromParameters(Long petId, String pedigreeId, String petName, String birthDate, Long speciesId, String gender, MultipartFile photo, String metric, Long breedId, Long furTypeId, Long colorId, Long breederId, Long fatherId, Long motherId) throws IllegalArgumentException, ParseException {
        Pet newPet = findById(petId);
        if (newPet == null) newPet = new Pet();
        newPet.setId(petId);
        if (pedigreeId != null) newPet.setPedigreeId(pedigreeId);
        newPet.setName(petName);
        newPet.setBirthday(dateService.stringToDate(birthDate));
        newPet.setSpecies(speciesRepository.findById(speciesId).get());
        newPet.setGender(gender);
        newPet.setMetricId(metric);
        newPet.setBreed(breedRepository.findById(breedId).get());
        newPet.setFurType(furTypeRepository.findById(furTypeId).get());
        newPet.setColor(colorRepository.findById(colorId).get());
        newPet.setBreeder(breederRepository.findById(breederId).get());
        newPet.setFather((fatherId == null) ? null : petRepository.findById(fatherId).get());
        newPet.setMother((motherId == null) ? null : petRepository.findById(motherId).get());
        validateParents(newPet);
        petRepository.save(newPet);

        imageService.saveOrUpdateImage(newPet, photo);
        petRepository.save(newPet);
        return "Питомец " + newPet.getName() + " сохраненён.";
    }

    private void validateParents(Pet pet) throws IllegalArgumentException {
        if (pet.getFather() != null) {
            if (pet.getBirthday().before(pet.getFather().getBirthday())) {
                throw new IllegalArgumentException("Отец не может быть моложе ребёнка");
            }
        }
        if (pet.getMother() != null) {
            if (pet.getBirthday().before(pet.getMother().getBirthday())) {
                throw new IllegalArgumentException("Отец не может быть моложе ребёнка");
            }
        }
    }

    public PetFormParameters getPetFormParameters() {
        PetFormParameters parameters = new PetFormParameters();
        parameters.setBreeders(breederRepository.findByOrderByBreederNameAsc());
        parameters.setBreeds(breedRepository.findByOrderByBreedNameAsc());
        parameters.setFurTypes(furTypeRepository.findByOrderByFurTypeNameAsc());
        parameters.setColors(colorRepository.findByOrderByColorNameAsc());
        parameters.setSpecies(speciesRepository.findByOrderBySpeciesNameAsc());
        parameters.setFemales(petRepository.findByGenderOrderByNameAsc("female 0,1"));
        parameters.setMales(petRepository.findByGenderOrderByNameAsc("male 1,0"));
        return parameters;
    }

    public PetFormParameters getPetFormParameters(Long id) {
        PetFormParameters petFormParameters = getPetFormParameters();

        Pet pet = findById(id);

        petFormParameters.setFemales(petRepository.findByGenderAndSpeciesAndBirthdayLessThanOrderByNameAsc(Pet.getFemaleGenderName(), pet.getSpecies(), pet.getBirthday()));
        petFormParameters.setMales(petRepository.findByGenderAndSpeciesAndBirthdayLessThanOrderByNameAsc(Pet.getMaleGenderName(), pet.getSpecies(), pet.getBirthday()));
        petFormParameters.setBirthday(dateService.dateToString(pet.getBirthday()));
        return petFormParameters;
    }

//    @Transactional
//    public void savePet(Pet pet) {
//        if (pet.getMother() != null)
//            pet.setMother(petRepository.findByNameAndBreeder(pet.getMother().getName(), pet.getMother().getBreeder()).get(0));
//        if (pet.getFather() != null)
//            pet.setFather(petRepository.findByNameAndBreeder(pet.getFather().getName(), pet.getFather().getBreeder()).get(0));
//
//        if (speciesRepository.findBySpeciesNameIgnoreCase(pet.getSpecies().getSpeciesName()).size() == 0)
//            speciesRepository.save(pet.getSpecies());
//        if (colorRepository.findByColorNameIgnoreCaseOrderByColorNameAsc(pet.getColor().getColorName()).size() == 0)
//            colorRepository.save(pet.getColor());
//        if (breedRepository.findByBreedNameIgnoreCase(pet.getBreed().getBreedName()).size() == 0)
//            breedRepository.save(pet.getBreed());
//        if (breederRepository.findByKennelNameIgnoreCase(pet.getBreeder().getKennelName()).size() == 0)
//            breederRepository.save(pet.getBreeder());
//
//        pet.setSpecies(speciesRepository.findBySpeciesNameIgnoreCase(pet.getSpecies().getSpeciesName()).get(0));
//        pet.setColor(colorRepository.findByColorNameIgnoreCaseOrderByColorNameAsc(pet.getColor().getColorName()).get(0));
//        pet.setBreed(breedRepository.findByBreedNameIgnoreCase(pet.getBreed().getBreedName()).get(0));
//        pet.setBreeder(breederRepository.findByKennelNameIgnoreCase(pet.getBreeder().getKennelName()).get(0));
//
//        petRepository.save(pet);
//    }

    public List<Pet> findAll() {
        List result = petRepository.findAll();
        return result.isEmpty() ? null : result;
    }

    public String getImagePathById(Long id) {
        Pet pet = findById(id);
        return pet == null ? null : pet.getImagePath();
    }

    public Pet findById(Long id) {
        if (id == null) return null;
        Optional<Pet> result = petRepository.findById(id);
        return result.isEmpty() ? null : result.get();
    }

    public String getBirthdayAsString(Pet pet) {
        if (pet.getBirthday() == null) return "";
        return dateService.dateToString(pet.getBirthday());
    }

    public void deleteImageByPetId(Long id) {
        Pet pet = findById(id);
        String path = pet.getImagePath();
        if (path != null) imageService.deleteImage(path);
        pet.setImagePath(null);
        petRepository.save(pet);
    }

    public Pet preparePetForPedigree(Pet pet, int generations) {
        if (generations == 0) return pet;
        if (pet.getFather() == null) pet.setFather(createBlankPet());
        if (pet.getMother() == null) pet.setMother(createBlankPet());

        preparePetForPedigree(pet.getFather(), generations - 1);
        preparePetForPedigree(pet.getMother(), generations - 1);

        return pet;
    }

    private Pet createBlankPet() {
        Breeder breeder = new Breeder();
        breeder.setBreederName("???");
        breeder.setKennelName("???");

        Pet blank = new Pet();
        blank.setName("???");
        blank.setBreeder(breeder);
        blank.setBreed(new Breed("???"));
        blank.setColor(new Color("???"));
        blank.setBirthday(null);
        return blank;
    }
}

