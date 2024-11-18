package FeignClients;

import Entities.Monopatin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "microservicio-monopatin")
public interface MonopatinFeign {
    @GetMapping("api/microservicioMonopatin/monopatinesCercanos/{posX}/{posY}")
    public List<Object[]> getMonopatinesCercanos(@PathVariable("posX") int posX, @PathVariable("posY") int posY);
}
