package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.backendchallanges.UserTable;

@Repository
public interface CreateUserRepository extends JpaRepository<UserTable, Long> {

    List<UserTable> findByEmail(String email); 

} 
