package com.pedigree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Breeder {
    @Id
    @GeneratedValue
    private Long id;

    private String kennelName;

    private String breederName;

    private String email;

    private String phoneNumber;

    private String siteAddress;

    private String breederAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKennelName() { return kennelName; }

    public void setKennelName(String kennelName) {
        this.kennelName = kennelName;
    }

    public String getBreederName() {
        return breederName;
    }

    public void setBreederName(String breederName) {
        this.breederName = breederName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getBreederAddress() {
        return breederAddress;
    }

    public void setBreederAddress(String breederAddress) {
        this.breederAddress = breederAddress;
    }

    @Override
    public String toString() {
        return "Breeder{" +
                "id=" + id +
                ", kennelName='" + kennelName + '\'' +
                ", breederName='" + breederName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", siteAddress='" + siteAddress + '\'' +
                "}\n";
    }
}
