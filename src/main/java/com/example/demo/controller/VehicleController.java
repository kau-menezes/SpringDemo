package com.example.demo.controller;

import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.VehicleData;
import com.example.demo.model.Vehicle;
import com.example.demo.repositories.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired VehicleRepository repo;

    @GetMapping
    public ResponseEntity<Vehicle> getBtId(Long id) {
        var vehicle = repo.findById(id);

        if (vehicle ==  null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(vehicle.get(), HttpStatus.OK);
    }

    @GetMapping("/find/{type}")
    public ResponseEntity<List<VehicleData>> getByType(@PathVariable String type) {
        var vehicles = repo.findByType(type)
        .stream()
        .map(v -> new VehicleData(v.getWheelCount(), v.getType()))
        .collect(Collectors.toList());

        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
}
