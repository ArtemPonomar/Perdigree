package com.pedigree.repository;

import com.pedigree.entity.pet_related.Breed;
import org.springframework.data.repository.CrudRepository;

public interface BreedRepository extends CrudRepository<Breed,Long> {
    Breed findByBreed(String breed);
}