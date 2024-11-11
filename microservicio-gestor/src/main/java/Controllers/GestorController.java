package Controllers;

import Entities.Gestor;
import Entities.Monopatin;
import Entities.Parada;
import Services.GestorService;
import dtos.MonopatinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/microservicioGestor/gestor")
public class GestorController {

    @Autowired
    GestorService gestorService;


    @PostMapping("/monopatin/agregarMonopatin")
    public ResponseEntity<Monopatin> agregarMonopatin(@RequestBody Monopatin monopatin) {
        Monopatin nuevoMonopatin = gestorService.insertarMonopatin(monopatin);
        return ResponseEntity.ok(nuevoMonopatin);
    }

    @PostMapping("/monopatin/quitarMonopatin/{idMonopatin}")
    public ResponseEntity<Void> quitarMonopatin(@PathVariable int idMonopatin){
        gestorService.borrarMonopatin(idMonopatin);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/parada/agregarParada")
    public ResponseEntity<Parada> agregarParada(@RequestBody Parada parada) {
        Parada nuevaParada = gestorService.insertarParada(parada);
        return ResponseEntity.ok(nuevaParada);
    }

    @DeleteMapping("/parada/quitarParada/{idParada}")
    public ResponseEntity<Void> quitarParada(@PathVariable int idParada) {
        gestorService.borrarParada(idParada);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/monopatin/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
    public ResponseEntity<Void> ubicarMonopatinEnParada(@PathVariable int idMonopatin, int idParada){
        gestorService.ubicarMonopatin(idMonopatin,idParada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/monopatin/iniciarMantenimiento/{idMonopatin}")
    public ResponseEntity<Void>iniciarMantenimientoMonopatin(@PathVariable int idMonopatin){
        gestorService.iniciarMantenimientoMonopatin(idMonopatin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/monopatin/finalizarMantenimiento/{idMonopatin}/{idParada}")
    public ResponseEntity<Void>finalizarMantenimientoMonopatin(@PathVariable int idMonopatin, @PathVariable int idParada){
        gestorService.finalizarMantenimientoMonopatin(idMonopatin, idParada);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/monopatin/getMonopatinesOperativosYMantenimiento")
    public ResponseEntity<List<Object[]>> getMonopatinesOperativosYMantenimiento(){
        List<Object[]> reporte = gestorService.getMonopatinesOperativosYMantenimiento();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/xViajesXAnio/{cantViajes}/{anio}")
    public ResponseEntity<List<Object[]>> getMonopatinesConMasDeXViajesXAnio(@PathVariable int cantViajes, @PathVariable int anio){
        List<Object[]> reporte = gestorService.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/monopatin/reporteDeUso/{incluirPausas}")
    public ResponseEntity<List<Object[]>> getReporteDeUso(@PathVariable boolean incluirPausas){
        List<Object[]> reporte = gestorService.getReporteDeUso(incluirPausas);
        return ResponseEntity.ok(reporte);
    }

    @PutMapping("/tarifas/ajustarTarifaViaje/{nuevaTarifa}/{fecha}")
    public ResponseEntity<Void> ajustarTarifaViaje(@PathVariable int nuevaTarifa,@PathVariable Date fecha){
        gestorService.ajustarTarifaViaje(nuevaTarifa,fecha);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/tarifas/ajustarTarifaPausa/{nuevaTarifa}/{fecha}")
    public ResponseEntity<Void> ajustarTarifaPausa(@PathVariable int nuevaTarifa,@PathVariable Date fecha){
        gestorService.ajustarTarifaPausa(nuevaTarifa,fecha);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/usuarios/anularUsuario/{idUsuario}")
    public ResponseEntity<Void> anularUsuario(@PathVariable int idUsuario){
        gestorService.anularUsuario(idUsuario);
        return ResponseEntity.status(201).build();
    }

}
