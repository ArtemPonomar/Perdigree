package com.pedigree.repository;

import com.pedigree.entity.Breeder;
import org.springframework.data.repository.CrudRepository;

public interface BreederRepository extends CrudRepository<Breeder, Long> {
    Breeder getByKennelName(String kennelName);
}
