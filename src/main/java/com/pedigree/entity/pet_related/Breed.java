package com.pedigree.entity.pet_related;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Breed {
    @Id
    @GeneratedValue
    private Long id;

    private String breed;

    public Breed(){}

    public Breed(String breedName){
        this.breed = breedName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Breed)) return false;
        Breed breed1 = (Breed) o;
        return Objects.equals(breed, breed1.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.breed);
    }
}
