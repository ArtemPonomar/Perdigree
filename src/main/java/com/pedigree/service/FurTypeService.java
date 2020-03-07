package com.pedigree.service;

import com.pedigree.entity.pet_related.FurType;
import com.pedigree.repository.FurTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FurTypeService {
    @Autowired
    private FurTypeRepository furTypeRepository;

    public List<FurType> getFurTypes() {
        return furTypeRepository.findByOrderByFurTypeNameAsc();
    }

    public FurType getByFurTypeName(String breedName) {
        List<FurType> searchResult = furTypeRepository.findByFurTypeName(breedName);
        if (searchResult.size() == 0) return null;
        return searchResult.get(0);
    }

    @Transactional
    public void saveFurType(FurType furType){
        List<FurType> dups = furTypeRepository.findByFurTypeName(furType.getFurTypeName());
        if (dups.size() != 0) {
            furType.setId(dups.get(0).getId());
        }
        furTypeRepository.save(furType);
    }
}
