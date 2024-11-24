package edu.unicen.exa.microserviciousuario.Repositories;

import edu.unicen.exa.microserviciousuario.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.cuentaActiva = false")
    public void anularUsuario(int idUsuario);
}