package edu.unicen.exa.microservicioparada.Repositories;

import edu.unicen.exa.microservicioparada.Entities.Parada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParadaRepository extends JpaRepository<Parada, Integer> {
}
