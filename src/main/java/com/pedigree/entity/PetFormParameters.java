package com.pedigree.entity;

import com.pedigree.entity.pet_related.Breed;
import com.pedigree.entity.pet_related.Color;
import com.pedigree.entity.pet_related.Pet;
import com.pedigree.entity.pet_related.Species;

import java.util.List;

public class PetFormParameters {
    List<Species> species;
    List<Color> colors;
    List<Breed> breeds;
    List<Pet> males;
    List<Pet> females;
    List<Breeder> breeders;

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }

    public List<Pet> getMales() {
        return males;
    }

    public void setMales(List<Pet> males) {
        this.males = males;
    }

    public List<Pet> getFemales() {
        return females;
    }

    public void setFemales(List<Pet> females) {
        this.females = females;
    }

    public List<Breeder> getBreeders() {
        return breeders;
    }

    public void setBreeders(List<Breeder> breeders) {
        this.breeders = breeders;
    }
}
