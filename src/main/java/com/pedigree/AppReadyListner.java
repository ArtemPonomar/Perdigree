package com.pedigree;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.PetFormParameters;
import com.pedigree.entity.pet_related.*;
import com.pedigree.repository.ColorRepository;
import com.pedigree.repository.PetRepository;
import com.pedigree.service.BreederService;
import com.pedigree.service.PetService;
import com.pedigree.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


@Component
public class AppReadyListner {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private BreederService breederService;

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @EventListener(ApplicationReadyEvent.class)
    private void init() {


//        PetFormParameters pfp = petService.getPetFormParameters();
//        for (Breed breed : pfp.getBreeds()){
//            System.out.println(breed.getBreedName() + " ");
//        }
//        System.out.println("---------------------------------");
//        for (Color color : pfp.getColors()){
//            System.out.println(color.getColorName() + " ");
//        }
//        System.out.println("---------------------------------");
//        for (Breeder breeder : pfp.getBreeders()){
//            System.out.println(breeder.getKennelName() + " ");
//        }
//        System.out.println("---------------------------------");
//        for (Pet f : pfp.getMales()){
//            System.out.println(f.getName() + " ");
//        }
//        System.out.println("---------------------------------");
//        for (Pet m : pfp.getFemales()){
//            System.out.println(m.getName() + " ");
//        }
//        System.out.println("---------------------------------");
//        for (Species s : pfp.getSpeciesName()){
//            System.out.println(s.getSpeciesName() + " ");
//        }
//        System.out.println("---------------------------------");
//
        Breeder breeder = new Breeder();
        breeder.setKennelName("Терем-теремок");
        breeder.setBreederName("Пономаренко Людмила");
        breeder.setEmail("terem-teremok@ukr.net");
        breeder.setPhoneNumber("067 218-60-18");
        breeder.setSiteAddress("https://terem-teremok.kiev.ua/");
        breederService.save(breeder);

        Pet mom = new Pet();
        mom.setBirthday("19.06.2011");
        mom.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
        mom.setBreeder(breederService.findByKennelName("Терем-теремок"));
        mom.setColor(new Color("Коричневый мардер"));
        mom.setFather(null);
        mom.setGender(Gender.female);
        mom.setImagePath("image_path");
        mom.setMetricId("NEW_metric_id");
        mom.setMother(null);
        mom.setName("Сара Мелинда");
        mom.setPedigreeId("Pedigree_id");
        mom.setSpecies(new Species("Кролик"));
        petService.savePet(mom);

        Pet dad = new Pet();
        dad.setBirthday("16.06.2012");
        dad.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
        dad.setBreeder(breederService.findByKennelName("Терем-теремок"));
        dad.setColor(new Color("Сиамская желтая"));
        dad.setFather(null);
        dad.setGender(Gender.male);
        dad.setImagePath("image_path");
        dad.setMetricId("NEW_metric_id");
        dad.setMother(null);
        dad.setName("Маркиз");
        dad.setPedigreeId("Pedigree_id");
        dad.setSpecies(new Species("Кролик"));
        petService.savePet(dad);

        Pet pet = new Pet();
        pet.setBirthday("23.02.2014");
        pet.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
        pet.setBreeder(breederService.findByKennelName("Терем-теремок"));
        pet.setColor(new Color("Сиамская коричневая"));
        pet.setFather(dad);
        pet.setGender(Gender.female);
        pet.setImagePath("image_path");
        pet.setMetricId("NEW_metric_id");
        pet.setMother(mom);
        pet.setName("Лапушка");
        pet.setPedigreeId("Pedigree_id");
        pet.setSpecies(new Species("Кролик"));
        petService.savePet(pet);

//        Pet pet = petRepository.findById(7l).get();
//        pet.setMetricId("newID");
//        petService.updatePet(pet);

//        Color color = colorRepository.findById(3l).get();
//        color.setColorName("Коричневый мардер");
//        colorRepository.save(color);
//        try {
//            File file = new File("myNewDir");
//            file.mkdir();
//            System.out.println(file.exists());
//            System.out.println(file.getAbsolutePath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
