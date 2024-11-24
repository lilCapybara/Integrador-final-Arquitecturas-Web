package edu.unicen.exa.microserviciogestor.FeignClients;

import edu.unicen.exa.microserviciomonopatin.Entities.Monopatin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservicio-monopatin")
public interface MonopatinFeign {

    @PostMapping("api/microservicioMonopatin/agregarMonopatin")
    public Monopatin insertarMonopatin(Monopatin monopatin);

    @DeleteMapping("api/microservicioMonopatin/quitarMonopatin/{idMonopatin}")
    public void borrarMonopatin(@PathVariable("idMonopatin") int idMonopatin);

    @PutMapping("api/microservicioMonopatin/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
    public void ubicarMonopatin(@PathVariable("idMonopatin") int idMonopatin,@PathVariable("idParada") int idParada);

    @PutMapping("api/microservicioMonopatin/iniciarMantenimiento/{idMonopatin}")
    public void iniciarMantenimientoMonopatin(@PathVariable("idMonopatin") int idMonopatin);

    @PutMapping("api/microservicioMonopatin/finalizarMantenimiento/{idMonopatin}/{idParada}")
    public void finalizarMantenimientoMonopatin(@PathVariable("idMonopatin") int idMonopatin, @PathVariable("idParada") int idParada);

    //Servicios pedidos en la consigna

    @GetMapping("api/microservicioMonopatin/monopatinesSegunEstado")
    public List<Object[]> getMonopatinesOperativosYMantenimiento();

    @GetMapping("api/microservicioMonopatin/xViajesXAnio/{cantViajes}/{anio}")
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(@PathVariable("cantViajes") int cantViajes, @PathVariable("anio") int anio);

    @GetMapping("api/microservicioMonopatin/reporteDeUso/{incluirPausas}")
    public List<Object[]> getReporteDeUso(@PathVariable boolean incluirPausas);
}
