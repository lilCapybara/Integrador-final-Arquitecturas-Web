package FeignClients;

import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface MonopatinFeign {

    @GetMapping("api/microservicioMonopatin/monopatinesSegunEstado")
    public List<Object[]> getMonopatinesOperativosYMantenimiento();

    @GetMapping("api/microservicioMonopatin/xViajesXAnio/{cantViajes}/{anio}")
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(@PathVariable("cantViajes") int cantViajes, @PathVariable("anio") int anio);

    @GetMapping("api/microservicioMonopatin/reporteDeUso/{incluirPausas}")
    public List<Object[]> getReporteDeUso(@PathVariable boolean incluirPausas);
}
