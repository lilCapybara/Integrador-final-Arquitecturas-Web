package Repositories;

import Entities.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository <Gestor, Integer> {
}
