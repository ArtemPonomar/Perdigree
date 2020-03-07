package com.pedigree.entity.pet_related;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FurType {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String furTypeName;

    public FurType() {
    }

    public FurType(String furTypeName) {
        this.furTypeName = furTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFurTypeName() {
        if (furTypeName == null) return "";
        return furTypeName;
    }

    public void setFurTypeName(String furTypeName) {
        this.furTypeName = furTypeName;
    }
}
