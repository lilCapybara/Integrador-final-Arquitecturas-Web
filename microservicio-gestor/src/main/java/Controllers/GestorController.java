package Controllers;

import Entities.Gestor;
import Entities.Monopatin;
import Entities.Parada;
import Services.GestorService;
import dtos.MonopatinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/microservicioGestor/gestor")
public class GestorController {

    @Autowired
    GestorService gestorService;


    @PostMapping("/agregarMonopatin")
    public ResponseEntity<Monopatin> agregarMonopatin(@RequestBody Monopatin monopatin) {
        Monopatin nuevoMonopatin = gestorService.insertarMonopatin(monopatin);
        return ResponseEntity.ok(nuevoMonopatin);
    }

    @PostMapping("/quitarMonopatin/{idMonopatin}")
    public ResponseEntity<Void> quitarMonopatin(@PathVariable int idMonopatin){
        gestorService.borrarMonopatin(idMonopatin);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/agregarParada")
    public ResponseEntity<Parada> agregarParada(@RequestBody Parada parada) {
        Parada nuevaParada = gestorService.insertarParada(parada);
        return ResponseEntity.ok(nuevaParada);
    }

    @DeleteMapping("quitarParada/{idParada}")
    public ResponseEntity<Void> quitarParada(@PathVariable int idParada) {
        gestorService.borrarParada(idParada);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
    public ResponseEntity<Void> ubicarMonopatinEnParada(@PathVariable int idMonopatin, int idParada){
        gestorService.ubicarMonopatin(idMonopatin,idParada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/iniciarMantenimientoMonopatin/{idMonopatin}")
    public ResponseEntity<Void>iniciarMantenimientoMonopatin(@PathVariable int idMonopatin){
        gestorService.iniciarMantenimientoMonopatin(idMonopatin);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/finalizarMantenimientoMonopatin/{idMonopatin}")
    public ResponseEntity<Void>finalizarMantenimientoMonopatin(@PathVariable int idMonopatin){
        gestorService.finalizarMantenimientoMonopatin(idMonopatin);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/getMonopatinesOperativosYMantenimiento")
    public ResponseEntity<List<Object[]>> getMonopatinesOperativosYMantenimiento(){
        List<Object[]> reporte = gestorService.getMonopatinesOperativosYMantenimiento();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/xViajesXAnio/{cantViajes}/{anio}")
    public ResponseEntity<List<Object[]>> getMonopatinesConMasDeXViajesXAnio(@PathVariable int cantViajes, @PathVariable int anio){
        List<Object[]> reporte = gestorService.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
        return ResponseEntity.ok(reporte);
    }


}
