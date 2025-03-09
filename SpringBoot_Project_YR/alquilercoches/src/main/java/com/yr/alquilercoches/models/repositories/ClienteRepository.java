package com.yr.alquilercoches.models.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yr.alquilercoches.models.entities.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByUsername(String username);
}
