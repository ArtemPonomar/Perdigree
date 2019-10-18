package com.pedigree.service;

import com.pedigree.entity.pet_related.Species;
import com.pedigree.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    public Species getBySpeciesName(String speciesName) {
        List<Species> searchResult = speciesRepository.findBySpeciesNameIgnoreCase(speciesName);
        if (searchResult.size() == 0) return null;
        return searchResult.get(0);
    }

    @Transactional
    public void saveSpecies(Species species){
        List<Species> dups = speciesRepository.findBySpeciesNameIgnoreCase(species.getSpeciesName());
        if (dups.size() != 0) {
            species.setId(dups.get(0).getId());
        }
        speciesRepository.save(species);
    }


}
