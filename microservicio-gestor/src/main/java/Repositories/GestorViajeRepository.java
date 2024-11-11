package Repositories;

import Entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface GestorViajeRepository extends JpaRepository<Viaje,Integer> {

    @Query("")
   public List<Object[]> getFacturacion(Date mesInicio, Date mesFin);
}
