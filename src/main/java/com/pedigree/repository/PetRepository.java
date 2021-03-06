package com.pedigree.repository;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.pet_related.Pet;
import com.pedigree.entity.pet_related.Species;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByNameAndBreeder(String petName, Breeder breeder);
    List<Pet> findAll();
    List<Pet> findByGenderOrderByNameAsc(String gender);
    List<Pet> findByGenderAndSpeciesAndBirthdayLessThanOrderByNameAsc(String gender, Species species, Date birthday);

    List<Pet> findAllByBirthdayBetween(Date Start, Date End);
}
