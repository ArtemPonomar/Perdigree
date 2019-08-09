package com.pedigree.repository;

import com.pedigree.entity.Breeder;
import com.pedigree.entity.pet_related.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
    Pet findByNameAndBreeder(String petName, Breeder breeder);
}
