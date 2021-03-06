package com.pedigree.repository;

import com.pedigree.entity.pet_related.Species;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SpeciesRepository extends CrudRepository<Species,Long> {
    List<Species> findBySpeciesNameIgnoreCase(String speciesName);
    List<Species> findByOrderBySpeciesNameAsc();
}