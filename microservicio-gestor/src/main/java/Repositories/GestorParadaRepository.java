package Repositories;

import Entities.Monopatin;
import Entities.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorParadaRepository extends JpaRepository<Parada, Integer> {


}
