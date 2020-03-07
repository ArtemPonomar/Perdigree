package com.pedigree.entity;

import com.pedigree.entity.pet_related.*;

import java.util.List;

public class PetFormParameters {
    List<Species> species;
    List<Color> colors;
    List<Breed> breeds;
    List<Pet> males;
    List<Pet> females;
    List<Breeder> breeders;
    List<FurType> furTypes;
    String birthday;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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

    public List<FurType> getFurTypes() {
        return furTypes;
    }

    public void setFurTypes(List<FurType> furTypes) {
        this.furTypes = furTypes;
    }
}
