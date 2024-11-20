package Controllers;

import Entities.Monopatin;
import Services.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/microservicioMonopatin")
public class MonopatinController {

    @Autowired
    private MonopatinService monopatinService;

    @PostMapping("/agregarMonopatin")
    public ResponseEntity<Monopatin> agregarMonopatin(@RequestBody Monopatin monopatin) {
        Monopatin nuevoMonopatin = monopatinService.insertarMonopatin(monopatin);
        return ResponseEntity.ok(nuevoMonopatin);
    }

    @DeleteMapping("/quitarMonopatin/{idMonopatin}")
    public ResponseEntity<Void> quitarMonopatin(@PathVariable int idMonopatin){
        monopatinService.borrarMonopatin(idMonopatin);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
    public ResponseEntity<Void> ubicarMonopatinEnParada(@PathVariable("idMonopatin") int idMonopatin, @PathVariable("idParada") int idParada){
        monopatinService.ubicarMonopatin(idMonopatin,idParada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/iniciarMantenimiento/{idMonopatin}")
    public ResponseEntity<Void>iniciarMantenimientoMonopatin(@PathVariable int idMonopatin){
        monopatinService.iniciarMantenimientoMonopatin(idMonopatin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/finalizarMantenimiento/{idMonopatin}/{idParada}")
    public ResponseEntity<Void>finalizarMantenimientoMonopatin(@PathVariable int idMonopatin, @PathVariable int idParada){
        monopatinService.finalizarMantenimientoMonopatin(idMonopatin, idParada);
        return ResponseEntity.status(201).build();
    }

    //Servicios pedidos en la consigna

    // 3a) Genera reportes de uso con o sin tiempos de pausa
    @GetMapping("/reporteDeUso/{incluirPausas}")
    public List<Object[]> getReporteDeUso(@PathVariable boolean incluirPausas){
        return monopatinService.getReporteDeUso(incluirPausas);
    };

    // 3c) Me da una lista de los monopatines que tengan mas de x viajes en cierto año
    @GetMapping("/xViajesXAnio/{cantViajes}/{anio}")
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(@PathVariable int cantViajes, @PathVariable int anio){
        return monopatinService.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
    }

    // 3e) Muestra la cantidad de monopatines en operacion y en mantenimiento
    @GetMapping("/monopatinesSegunEstado")
    public List<Object[]>getMonopatinesOperativosYMantenimiento(){
        return monopatinService.getMonopatinesOperativosYMantenimiento();
    }

    // 3g) Obtiene un listado de los monopatines mas cercanos a la posicion (x,y) del usuario
    @GetMapping("/monopatinesCercanos/{posX}/{posY}")
    public List<Object[]> getMonopatinesCercanos(@PathVariable("posX") int posUsuarioX,@PathVariable("posY") int posUsuarioY){
       return monopatinService.getMonopatinesCercanos(posUsuarioX,posUsuarioY);
    }
}
