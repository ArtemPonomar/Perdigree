package com.pedigree.entity;

import javax.persistence.*;

@Entity
public class PetTest {

    @Id
    @GeneratedValue
    private long id;

    private long name;

    @ManyToOne
    @JoinColumn(name = "colourTest_id")
    private ColorTest colorTest;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private PetTest father;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public ColorTest getColorTest() {
        return colorTest;
    }

    public void setColorTest(ColorTest colorTest) {
        this.colorTest = colorTest;
    }

    public PetTest getFather() {
        return father;
    }

    public void setFather(PetTest father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "PetTest{" +
                "id=" + id +
                ", name=" + name +
                ", colorTest=" + colorTest +
                ", father=" + father +
                '}';
    }
}
