package edu.unicen.exa.microservicioviaje.Repositories;

import edu.unicen.exa.microservicioviaje.Entities.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
    @Query("SELECT SUM(v.precioTotal) FROM Viaje v " +
            "WHERE YEAR(v.fechaInicio) = YEAR(:anio)" +
            "AND v.fechaInicio BETWEEN :mesInicio AND :mesFin")
    public Double getFacturacion(@Param("anio") Date anio, @Param("mesInicio") Date mesInicio, @Param("mesFin") Date mesFin);

    @Modifying
    @Transactional
    @Query("UPDATE PrecioViaje p SET p.precioXKilometro = :nuevaTarifa, p.fechaAplicacion = :nuevaFecha WHERE p.idPrecio = :idPrecio")
    public void ajustarTarifaViaje(@Param("nuevaTarifa") int nuevaTarifa,  @Param("nuevaFecha")Date fechaAplicacion);

    @Modifying
    @Transactional
    @Query("UPDATE PrecioViaje p SET p.tarifaPausaExtensa = :nuevaTarifa, p.fechaAplicacion = :nuevaFecha WHERE p.idPrecio = :idPrecio")
    public void ajustarTarifaPausa(@Param("nuevaTarifa")int nuevaTarifa, @Param("nuevaFecha")Date fechaAplicacion);
}
