package com.pedigree.repository;

import com.pedigree.entity.pet_related.Color;
import org.springframework.data.repository.CrudRepository;

public interface ColorRepository extends CrudRepository<Color,Long> {
    Color findByColor(String color);
}