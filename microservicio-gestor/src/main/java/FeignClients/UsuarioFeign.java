package FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "microservicio-usuario")
public interface UsuarioFeign {
    // Habilita o deshabilita una cuenta
    @PutMapping("api/microservicioUsuario/usuarios/cambiarEstadoUsuario/{idUsuario}/{estado}")
    public void anularUsuario(@PathVariable("idUsuario") int id, @PathVariable boolean estado);
}
