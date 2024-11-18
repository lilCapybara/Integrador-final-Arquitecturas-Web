package FeignClients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MonopatinFeign {
    @GetMapping("api/microservicioMonopatin/monopatinesCercanos/{posX}/{posY}")
    public List<Object[]> getMonopatinesCercanos(@PathVariable("posX") int posX, @PathVariable("posY") int posY);
}
