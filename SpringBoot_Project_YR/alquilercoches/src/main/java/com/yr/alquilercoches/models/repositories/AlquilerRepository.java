package com.yr.alquilercoches.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yr.alquilercoches.models.entities.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, String>{
    
}
