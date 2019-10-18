package com.pedigree.repository;

import com.pedigree.entity.Breeder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreederRepository extends CrudRepository<Breeder, Long> {
    List<Breeder> findByKennelNameIgnoreCase(String kennelName);
    List<Breeder> findAll();
}
