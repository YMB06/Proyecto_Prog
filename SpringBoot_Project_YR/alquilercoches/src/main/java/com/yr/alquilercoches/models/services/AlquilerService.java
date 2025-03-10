package com.yr.alquilercoches.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import com.yr.alquilercoches.models.entities.Alquiler;
import com.yr.alquilercoches.models.repositories.AlquilerRepository;

@Service
public class AlquilerService {
    //Injecta todo el comportamiento del repositorio
    //GamasRepository en la propiedad gamasRep
    //de la clase GamasService
    @Autowired
    AlquilerRepository alquilerRepository;

    public List<Alquiler> getAll(){
        return this.alquilerRepository.findAll();
    }
    
    //create
    public Alquiler create(Alquiler alquiler){
        return this.alquilerRepository.save(alquiler);
    }

    //update
    public Alquiler update(Alquiler alquiler){
        return this.alquilerRepository.save(alquiler);
    }

    //delete
    public void delete(Alquiler alquiler){
        this.alquilerRepository.delete(alquiler);
    }

    //delete by id
    public void deleteById(Long id){
        this.alquilerRepository.deleteById(id);
    }
    //getid
    public Alquiler getId(Long id){
        Alquiler alquiler = this.alquilerRepository.findById(id).get();
        System.out.println(alquiler);
        return alquiler;
    }
    public List<Alquiler> findByCocheId(Long cocheId) {
        return alquilerRepository.findByCocheId(cocheId);
    }

    public List<Alquiler> findByClienteId(Long clienteId) {
        return alquilerRepository.findByClienteId(clienteId);
    }

    public List<Alquiler> getUltimosAlquileres(int limit) {
        return alquilerRepository.findTop10ByOrderByIdDesc();
    }

    public boolean isCarAvailable(Long carId, String startDate, String endDate) {
        try {
            List<Alquiler> existingRentals = alquilerRepository.findByCocheId(carId);
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);

            // First check if the dates are valid
            if (start.isAfter(end)) {
                return false;
            }

            // Check against existing rentals
            for (Alquiler rental : existingRentals) {
                try {
                    LocalDate rentalStart = LocalDate.parse(rental.getFecha_inicio());
                    LocalDate rentalEnd = LocalDate.parse(rental.getFecha_fin());

                    // Check if dates overlap
                    boolean overlap = !(end.isBefore(rentalStart) || start.isAfter(rentalEnd));
                    if (overlap) {
                        return false;
                    }
                } catch (Exception e) {
                    // Skip invalid dates in existing rentals
                    continue;
                }
            }
            return true;
        } catch (Exception e) {
            // If there's any error parsing dates or other issues, consider the car unavailable
            return false;
        }
    }

    
}
