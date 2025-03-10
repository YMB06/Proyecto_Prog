package com.yr.alquilercoches.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yr.alquilercoches.models.entities.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long>{
    List<Alquiler> findByCocheId(Long cocheId);
    List<Alquiler> findByClienteId(Long clienteId);
    List<Alquiler> findTop10ByOrderByIdDesc();


}
