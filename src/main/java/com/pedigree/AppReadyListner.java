package com.pedigree;

import com.pedigree.entity.ColorTest;
import com.pedigree.entity.PetTest;
import com.pedigree.entity.pet_related.*;
import com.pedigree.service.BreederService;
import com.pedigree.service.PetService;
import com.pedigree.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class AppReadyListner {

    @Autowired
    private BreederService breederService;

    @Autowired
    private PetService petService;

    @Autowired
    private ServiceTest serviceTest;

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        PetTest boomer = new PetTest();
        ColorTest col = new ColorTest();
        col.setColourName("Red");
        boomer.setColorTest(col);
        serviceTest.saveColourTest(col);
        //serviceTest.savePet(boomer);

//        Breeder breeder = new Breeder();
//        breeder.setKennelName("Терем-теремок");
//        breeder.setBreederName("Пономаренко Людмила");
//        breeder.setEmail("terem-teremok@ukr.net");
//        breeder.setPhoneNumber("067 218-60-18");
//        breeder.setSiteAddress("https://terem-teremok.kiev.ua/");
//
//        if (breederService.getBreeders().size() == 0){
//            breederService.save(breeder);
//        }

        //System.out.println(breederService.getByKennelName("Терем-теремок"));

//        Pet mom = new Pet();
//        mom.setBirthday("19.06.2011");
//        mom.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
//        mom.setBreeder(breederService.getByKennelName("Терем-теремок"));
//        mom.setColor(new Color("Коричневый мардер"));
//        mom.setFather(null);
//        mom.setGender(Gender.female);
//        mom.setImagePath("image_path");
//        mom.setMetricId("metric_id");
//        mom.setMother(null);
//        mom.setName("Сара Мелинда");
//        mom.setPedigreeId("Pedigree_id");
//        mom.setSpecies(new Species("Кролик"));
//
//        Pet dad = new Pet();
//        dad.setBirthday("16.06.2012");
//        dad.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
//        dad.setBreeder(breederService.getByKennelName("Терем-теремок"));
//        dad.setColor(new Color("Сиамская желтая"));
//        dad.setFather(null);
//        dad.setGender(Gender.male);
//        dad.setImagePath("image_path");
//        dad.setMetricId("metric_id");
//        dad.setMother(null);
//        dad.setName("Маркиз");
//        dad.setPedigreeId("Pedigree_id");
//        dad.setSpecies(new Species("Кролик"));
//
//        Pet pet = new Pet();
//        pet.setBirthday("23.02.2014");
//        pet.setBreed(new Breed("Нидерландский карликовый баран (NHD)"));
//        pet.setBreeder(breederService.getByKennelName("Терем-теремок"));
//        pet.setColor(new Color("Сиамская коричневая"));
//        pet.setFather(dad);
//        pet.setGender(Gender.female);
//        pet.setImagePath("image_path");
//        pet.setMetricId("metric_id");
//        pet.setMother(mom);
//        pet.setName("Лапушка");
//        pet.setPedigreeId("Pedigree_id");
//        pet.setSpecies(new Species("Кролик"));
//
//        petService.saveOrUpdate(mom);
//        petService.save(pet);
//        System.out.println(breederService.getBreeders().get(0));


//                            Colour c = new Colour();
//                            c.setColourName("Blue");
//                            testService.saveColour(c);
//
//
//                            Pet p = new Pet();
//                            p.setName("PetBlue");                                 *TestRepo*
//                            p.setColour(testService.getColour("Blue"));
//                            testService.savePet(p);
//
//                            System.out.println(testService.getPet("PetBlue"));

//        Pet petR = testService.getPet("PetRed");
//        System.out.println(petR);
//        System.out.println(petR.getFather());
//        System.out.println(petR.getFather().getFather());

//        Colour c = new Colour();
//        c.setColourName("Green");
//        testService.saveColour(c);
//
//        Pet pet = new Pet();
//        pet.setColour(c);
//        pet.setName("PetG");
//        testService.savePet(pet);
    }
}
