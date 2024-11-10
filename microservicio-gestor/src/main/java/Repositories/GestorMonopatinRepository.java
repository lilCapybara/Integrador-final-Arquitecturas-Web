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

    @Query("SELECT SUM(CASE WHEN m.estado = 'En mantenimiento' THEN 1 ELSE 0 END) AS MonopatinesEnMantenimiento, " +
            "SUM(CASE WHEN m.estado = 'Operativo' THEN 1 ELSE 0 END) AS MonopatinesOperativos " +
            "FROM Gestor g JOIN g.flotaDeMonopatines m")
    public List<Object[]> getMonopatinesOperativosYMantenimiento();

}
