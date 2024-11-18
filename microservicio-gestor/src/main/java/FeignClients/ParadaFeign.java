package FeignClients;

import Entities.Parada;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "microservicio-parada")
public interface ParadaFeign {
    @PostMapping("api/microservicioParada/agregarParada")
    public Parada insertarParada(Parada parada);

    @DeleteMapping("api/microservicioParada//quitarParada/{idParada}")
    public void borrarParada(@PathVariable("idParada") int idParada);
}
