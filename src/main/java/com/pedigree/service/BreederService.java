package com.pedigree.service;

import com.pedigree.entity.Breeder;
import com.pedigree.repository.BreederRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreederService {
    @Autowired
    private BreederRepository breederRepository;

    public List<Breeder> getBreeders(){
        List<Breeder> breeders = new ArrayList<>();
        for (Breeder breeder : breederRepository.findAll()){
            breeders.add(breeder);
        }
        return breeders;
    }

    public Breeder getByKennelName(String kennel){
        if (breederRepository.getByKennelName(kennel) == null) return null;
        return breederRepository.getByKennelName(kennel).get(0);
    }

    public void save(Breeder breeder){
        breederRepository.save(breeder);
    }

    public void save(Iterable<Breeder> breeders){
        breederRepository.saveAll(breeders);
    }
}
