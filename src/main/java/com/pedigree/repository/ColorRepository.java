package com.pedigree.repository;

import com.pedigree.entity.pet_related.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color,Long> {
    List<Color> findByColor(String color);
    List<Color> findAll();
}