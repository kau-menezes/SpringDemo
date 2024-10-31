package com.example.demo.model.backendchallanges;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Country;
    
    @Column
    private String CityName;

    @Column
    private String Abbreviation;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String WheelCount) {
        this.Country = WheelCount;
    }
    
    public String getCityName() {
        return CityName;
    }

    public void setCityName(String type) {
        this.CityName = type;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }

}
