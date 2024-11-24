package edu.unicen.exa.microserviciousuario.FeignClients;

import edu.unicen.exa.microservicioviaje.Entities.Viaje;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "microservicio-viaje")
public interface ViajeFeign {

    @PostMapping("api/microservicio-viaje/agregarViaje")
    public ResponseEntity<Viaje> agregarViaje(@RequestBody Viaje viaje);
}
