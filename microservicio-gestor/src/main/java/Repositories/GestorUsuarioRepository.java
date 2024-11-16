package Repositories;


import FeignClients.UsuarioFeign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GestorUsuarioRepository extends JpaRepository<UsuarioFeign, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.cuentaActiva = false")
    public void anularUsuario(int idUsuario);
}
