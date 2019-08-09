package com.pedigree.repository;

import com.pedigree.entity.ColorTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepo extends CrudRepository<ColorTest, Long> {
}
