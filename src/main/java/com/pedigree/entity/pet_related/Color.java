package com.pedigree.entity.pet_related;

import javax.persistence.*;

@Entity
public class Color {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String colorName;

    public  Color(){};

    public Color(String colorName) {
        this.colorName = colorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
