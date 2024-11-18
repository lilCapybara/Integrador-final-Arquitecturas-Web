package Controllers;

import Services.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/microservicioMonopatin")
public class MonopatinController {

    @Autowired
    private MonopatinService monopatinService;

    @GetMapping("/monopatinesSegunEstado")
    public List<Object[]>getMonopatinesOperativosYMantenimiento(){
        return monopatinService.getMonopatinesOperativosYMantenimiento();
    }

    @GetMapping("/xViajesXAnio/{cantViajes}/{anio}")
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(@PathVariable int cantViajes, @PathVariable int anio){
        return monopatinService.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
    }

    @GetMapping("/reporteDeUso/{incluirPausas}")
    public List<Object[]> getReporteDeUso(@PathVariable boolean incluirPausas){
        return monopatinService.getReporteDeUso(incluirPausas);
    };

    @GetMapping("/monopatinesCercanos/{posX}/{posY}")
    public List<Object[]> getMonopatinesCercanos(@PathVariable("posX") int posUsuarioX,@PathVariable("posY") int posUsuarioY){
       return monopatinService.getMonopatinesCercanos(posUsuarioX,posUsuarioY);
    }
}
