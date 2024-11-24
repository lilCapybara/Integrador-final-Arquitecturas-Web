package edu.unicen.exa.microserviciogestor.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "microservicio-usuario")
public interface UsuarioFeign {

    @PutMapping("api/microservicioUsuario/usuarios/cambiarEstadoUsuario/{idUsuario}/{estado}")
    public void cambiarEstadoUsuario(@PathVariable("idUsuario") int id, @PathVariable boolean estado);
}
