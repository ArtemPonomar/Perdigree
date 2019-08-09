package com.pedigree.repository;

import com.pedigree.entity.PetTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends CrudRepository<PetTest, Long> {
}
