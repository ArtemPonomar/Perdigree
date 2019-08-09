package com.pedigree.repository;

import com.pedigree.entity.pet_related.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species,Long> {
}