package com.pedigree.entity.pet_related;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Breed {
    @Id
    @GeneratedValue
    private Long id;

    private String breedName;

    public Breed(){}

    public Breed(String breedName){
        this.breedName = breedName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Breed)) return false;
        Breed breed1 = (Breed) o;
        return Objects.equals(breedName, breed1.breedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.breedName);
    }
}
