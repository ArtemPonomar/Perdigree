package com.pedigree.repository;

import com.pedigree.entity.pet_related.PetName;
import org.springframework.data.repository.CrudRepository;

public interface PetNameRepository extends CrudRepository<PetName,Long> {
}
