package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> { // classe e tipo do id
    List<Vehicle> findByType(String type); // findBy{NOME_EXATO_DA_COLUNA_NO_BANCO}
} 
