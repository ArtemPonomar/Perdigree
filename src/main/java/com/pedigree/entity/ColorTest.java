package com.pedigree.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ColorTest {
    @Id
    @GeneratedValue
    private Long id;

    private String colourName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    @Override
    public String toString() {
        return "ColorTest{" +
                "id=" + id +
                ", colourName='" + colourName + '\'' +
                '}';
    }
}
