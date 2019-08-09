package com.pedigree.entity.pet_related;

import com.pedigree.entity.Breeder;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String pedigreeId;

    @Column(unique = true)
    private String metricId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;

    private String imagePath;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Gender gender;

    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id")
    private Species species;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breed_id")
    private Breed breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "father_id")
    private Pet father;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mother_id")
    private Pet mother;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPedigreeId() { return pedigreeId; }

    public void setPedigreeId(String pedigreeId) { this.pedigreeId = pedigreeId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Breeder getBreeder() {
        return breeder;
    }

    public void setBreeder(Breeder breeder) {
        this.breeder = breeder;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Pet getFather() {
        return father;
    }

    public void setFather(Pet father) {
        this.father = father;
    }

    public Pet getMother() {
        return mother;
    }

    public void setMother(Pet mother) {
        this.mother = mother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(pedigreeId, pet.pedigreeId) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(breeder, pet.breeder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedigreeId, name, breeder);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", pedigreeId='" + pedigreeId + '\'' +
                ", metricId='" + metricId + '\'' +
                ", name='" + name + '\'' +
                ", breeder=" + breeder +
                ", imagePath='" + imagePath + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", species=" + species +
                ", breed=" + breed +
                ", color=" + color +
                '}';
    }
}
