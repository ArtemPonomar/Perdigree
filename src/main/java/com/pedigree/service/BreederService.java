package com.pedigree.service;

import com.pedigree.entity.Breeder;
import com.pedigree.repository.BreederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BreederService {
    @Autowired
    private BreederRepository breederRepository;

    public List<Breeder> getBreeders() {
        return breederRepository.findByOrderByBreederNameAsc();
    }

    public Breeder findByKennelName(String kennel) {
        List<Breeder> searchResult = breederRepository.findByKennelNameIgnoreCase(kennel);
        if (searchResult.size() == 0) return null;
        return searchResult.get(0);
    }

    @Transactional
    public void save(Breeder breeder) {
        List<Breeder> dups = breederRepository.findByKennelNameIgnoreCase(breeder.getKennelName());
        if (dups.size() != 0) {
            breeder.setId(dups.get(0).getId());
        }
        breederRepository.save(breeder);
    }
}
