package com.pedigree.repository;

import com.pedigree.entity.pet_related.Breed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreedRepository extends CrudRepository<Breed,Long> {
    List<Breed> findByBreed(String breed);
    List<Breed> findAll();
}