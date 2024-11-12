package Repositories;

import Entities.Viaje;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GestorViajeRepository extends JpaRepository<Viaje,Integer> {

    @Query("SELECT SUM(v.precioTotal) FROM Viaje v WHERE v.fechaInicio BETWEEN :mesInicio AND :mesFin")
    public Double getFacturacion(@Param("mesInicio") Date mesInicio, @Param("mesFin") Date mesFin);

}
