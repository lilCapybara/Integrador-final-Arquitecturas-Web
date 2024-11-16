package Repositories;

import Entities.Monopatin;
import dtos.MonopatinDTO;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GestorMonopatinRepository extends JpaRepository<Monopatin, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Monopatin m SET m.paradaActual.idParada = :idParada WHERE m.idMonopatin = :idMonopatin")
    public void ubicarMonopatin(@Param("idMonopatin") int idMonopatin, @Param("idParada") int idParada);

    @Modifying
    @Transactional
    @Query("UPDATE Monopatin m SET m.paradaActual.idParada = null WHERE m.idMonopatin = :idMonopatin")
    public void enviarATaller(int idMonopatin);

    @Query("SELECT SUM(CASE WHEN m.estado = 'En mantenimiento' THEN 1 ELSE 0 END) AS MonopatinesEnMantenimiento, " +
            "SUM(CASE WHEN m.estado = 'Operativo' THEN 1 ELSE 0 END) AS MonopatinesOperativos " +
            "FROM Gestor g JOIN g.flotaDeMonopatines m")
    public List<Object[]> getMonopatinesOperativosYMantenimiento();

    @Query("SELECT m " +
            "FROM Monopatin m JOIN m.viajeActual v " +
            "WHERE YEAR(v.fechaInicio) = :anio " +
            "GROUP BY m " +
            "HAVING COUNT(v) > :cantViajes")
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(@Param ("cantViajes") int cantViajes, @Param("anio") int anio);

    @Query("SELECT m, " +
            "SUM(m.kilometraje) AS kilometraje, " +
            "SUM(CASE WHEN :incluirPausas = true THEN m.horasDeUso + m.contadorPausa ELSE m.horasDeUso END) AS horasDeUso " +
            "FROM Monopatin m " +
            "GROUP BY m.idMonopatin")
    public List<Object[]> getReporteDeUso(@Param ("incluirPausas") boolean incluirPausas);


}
