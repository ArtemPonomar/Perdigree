package com.pedigree.repository;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.pet_related.Gender;
import com.pedigree.entity.pet_related.Pet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByNameAndBreeder(String petName, Breeder breeder);
    List<Pet> findAll();
    List<Pet> findByGender(Gender gender);
}
