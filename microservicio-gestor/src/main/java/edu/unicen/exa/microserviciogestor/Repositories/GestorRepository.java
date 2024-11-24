package edu.unicen.exa.microserviciogestor.Repositories;

import edu.unicen.exa.microserviciogestor.Entities.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository <Gestor, Integer> {
}
