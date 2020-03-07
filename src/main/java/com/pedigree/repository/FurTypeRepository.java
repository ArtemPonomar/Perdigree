package com.pedigree.repository;

import com.pedigree.entity.pet_related.FurType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurTypeRepository extends CrudRepository<FurType, Long> {
    List<FurType> findByFurTypeName(String furTypeName);
    List<FurType> findByOrderByFurTypeNameAsc();
}