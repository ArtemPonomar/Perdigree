package com.pedigree.entity.pet_related;

import javax.persistence.*;

@Entity
public class Color {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String color;

    public  Color(){};

    public Color(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
