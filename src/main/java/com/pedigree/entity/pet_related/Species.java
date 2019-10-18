package com.pedigree.entity.pet_related;

import javax.persistence.*;

@Entity
public class Species {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String speciesName;

    public Species(){}

    public Species(String speciesName) {
        this.speciesName = speciesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
}
