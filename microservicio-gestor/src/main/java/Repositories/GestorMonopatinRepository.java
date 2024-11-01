package Repositories;

import Entities.Monopatin;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GestorMonopatinRepository extends JpaRepository<Monopatin, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Monopatin m SET m.paradaActual.idParada = :idParada WHERE m.idMonopatin = :idMonopatin")
    public void ubicarMonopatin(@Param("idMonopatin") int idMonopatin, @Param("idParada") int idParada);



}
