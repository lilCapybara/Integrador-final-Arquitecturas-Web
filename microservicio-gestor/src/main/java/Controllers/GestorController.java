package Controllers;

import Entities.Gestor;
import Entities.Monopatin;
import Entities.Parada;
import Services.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/microservicioGestor/gestor")
public class GestorController {

    @Autowired
    GestorService gestorService;

    //CRUD de gestor

    @PostMapping("/agregarGestor")
    public ResponseEntity<Gestor> agregarGestor(@RequestBody Gestor gestor) {
        Gestor nuevoGestor=gestorService.insertarGestor(gestor);
        return ResponseEntity.ok().body(nuevoGestor);
    }

    @DeleteMapping("/borrarGestor/{idGestor}")
    public ResponseEntity<Gestor> borrarGestor(@PathVariable int idGestor) {
        gestorService.borrarGestor(idGestor);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping("/modificarGestor/{idGestor}")
    public ResponseEntity<Void> modificarGestor(@PathVariable int idGestor, @RequestBody Gestor nuevoGestor) {
        gestorService.modificarGestor(idGestor, nuevoGestor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getGestor/{idGestor}")
    public ResponseEntity<Gestor> getGestor(@PathVariable int idGestor) {
        Gestor gestorBuscado = gestorService.getGestor(idGestor);
        return ResponseEntity.ok().body(gestorBuscado);
    }

    @PostMapping("/monopatin/agregarMonopatin")
    public ResponseEntity<Monopatin> agregarMonopatin(@RequestBody Monopatin monopatin) {
        Monopatin nuevoMonopatin = gestorService.insertarMonopatin(monopatin);
        return ResponseEntity.ok(nuevoMonopatin);
    }

    @DeleteMapping("/monopatin/quitarMonopatin/{idMonopatin}")
    public ResponseEntity<Void> quitarMonopatin(@PathVariable int idMonopatin){
        gestorService.borrarMonopatin(idMonopatin);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/monopatin/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
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




    //Servicios pedidos en la consigna

    // 3a) Genera reportes de uso con o sin tiempos de pausa
    @GetMapping("/monopatin/reporteDeUso/{incluirPausas}")
    public ResponseEntity<List<Object[]>> getReporteDeUso(@PathVariable boolean incluirPausas){
        List<Object[]> reporte = gestorService.getReporteDeUso(incluirPausas);
        return ResponseEntity.ok(reporte);
    }

    // 3b) Funcion utilizada para anular cuentas de usuario
    @PutMapping("/usuarios/cambiarEstadoUsuario/{idUsuario}/{estado}")
    public ResponseEntity<Void> cambiarEstadoUsuario(@PathVariable int idUsuario, @PathVariable boolean estado){
        gestorService.cambiarEstadoUsuario(idUsuario,estado);
        return ResponseEntity.status(201).build();
    }

    // 3c) Me da una lista de los monopatines que tengan mas de x viajes en cierto año
    @GetMapping("/xViajesXAnio/{cantViajes}/{anio}")
    public ResponseEntity<List<Object[]>> getMonopatinesConMasDeXViajesXAnio(@PathVariable int cantViajes, @PathVariable int anio){
        List<Object[]> reporte = gestorService.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
        return ResponseEntity.ok(reporte);
    }

    // 3d) Me da la cantidad facturada entre dos meses de cierto año
    @GetMapping("/getFacturacion/{anio}/{mesInicio}/{mesFin}")
    public double getFacturacion(@PathVariable Date anio, @PathVariable Date mesInicio, @PathVariable Date mesFin){
        return gestorService.getFacturacion(anio,mesInicio,mesFin);
    }

    // 3e) Muestra la cantidad de monopatines en operacion y en mantenimiento
    @GetMapping("/monopatin/monopatinesSegunEstado")
    public ResponseEntity<List<Object[]>> getMonopatinesOperativosYMantenimiento(){
        List<Object[]> reporte = gestorService.getMonopatinesOperativosYMantenimiento();
        return ResponseEntity.ok(reporte);
    }

    // 3f) Funciones utilizadas para actualizar tarifas de viaje y de pausa
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

}
