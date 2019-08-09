package com.pedigree.entity.pet_related;

import javax.persistence.*;

@Entity
public class Species {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String species;

    public Species(){}

    public Species(String species) {
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
