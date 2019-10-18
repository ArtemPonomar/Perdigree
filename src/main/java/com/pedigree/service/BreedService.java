package com.pedigree.service;

import com.pedigree.entity.pet_related.Breed;
import com.pedigree.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BreedService {
    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> getBreeders() {
        return breedRepository.findAll();
    }

    public Breed getByBreedName(String breedName) {
        List<Breed> searchResult = breedRepository.findByBreedNameIgnoreCase(breedName);
        if (searchResult.size() == 0) return null;
        return searchResult.get(0);
    }

    @Transactional
    public void saveBreed(Breed breed){
        List<Breed> dups = breedRepository.findByBreedNameIgnoreCase(breed.getBreedName());
        if (dups.size() != 0) {
            breed.setId(dups.get(0).getId());
        }
        breedRepository.save(breed);
    }
}
