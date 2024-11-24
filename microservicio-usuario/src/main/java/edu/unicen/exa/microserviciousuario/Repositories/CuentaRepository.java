package edu.unicen.exa.microserviciousuario.Repositories;

import edu.unicen.exa.microserviciousuario.Entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
