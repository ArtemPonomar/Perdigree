package com.pedigree.entity.pet_related;

import com.pedigree.entity.Breeder;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String pedigreeId;

    @Column
    private String metricId;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Breeder breeder;

    private String imagePath;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Species species;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Breed breed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private Pet father;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
