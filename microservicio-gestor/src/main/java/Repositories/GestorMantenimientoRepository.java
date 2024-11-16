package Repositories;

import Entities.Monopatin;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface GestorMantenimientoRepository extends JpaRepository<Monopatin, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Monopatin m SET m.estado = :estado WHERE m.idMonopatin = :idMonopatin")
    public void iniciarMantenimiento(@Param("idMonopatin") int idMonopatin, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query("UPDATE Monopatin m SET m.estado = :estado WHERE m.idMonopatin = :idMonopatin")
    public void finalizarMantenimiento(@Param("idMonopatin") int idMonopatin, @Param("estado") String estado);
}
