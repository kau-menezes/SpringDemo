package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer WheelCount;
    
    @Column
    private String type;
    
    public Integer getWheelCount() {
        return WheelCount;
    }

    public void setWheelCount(Integer WheelCount) {
        this.WheelCount = WheelCount;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    

}
