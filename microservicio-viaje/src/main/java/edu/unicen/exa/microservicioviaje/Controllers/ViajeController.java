package edu.unicen.exa.microservicioviaje.Controllers;

import edu.unicen.exa.microservicioviaje.Entities.Viaje;
import edu.unicen.exa.microservicioviaje.Services.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/microservicioViaje")
public class ViajeController {
    @Autowired
    private ViajeService viajeService;

    @GetMapping("/encontrarPorId/{idViaje}")
    public ResponseEntity<Optional<Viaje>> encontrarPorId(@PathVariable int idViaje) {
        Optional<Viaje> nuevoViaje = viajeService.encontrarPorId(idViaje);
        return ResponseEntity.ok().body(nuevoViaje);
    }

    @GetMapping("/agregarViaje")
    public ResponseEntity<Viaje> agregarViaje(@RequestBody Viaje viaje) {
        Viaje nuevoViaje = viajeService.insertarViaje(viaje);
        return ResponseEntity.ok(nuevoViaje);
    }

    @PostMapping("/quitarViaje/{idViaje}")
    public ResponseEntity<Void> quitarViaje(@PathVariable int idViaje){
        viajeService.borrarViaje(idViaje);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificarViaje/{idViaje}")
    public ResponseEntity<Viaje> modificarViaje(@PathVariable int idViaje, @RequestBody Viaje viaje){
        Viaje viajeModificado = viajeService.modificarViaje(idViaje,viaje);
        return ResponseEntity.ok(viajeModificado);
    }

    @GetMapping("/facturacion/{anio}/{mesInicio}/{mesFin}")
    public double getFacturacion(@PathVariable("anio") Date anio, @PathVariable("mesInicio") Date mesInicio, @PathVariable("mesFin") Date mesFin){
        return viajeService.getFacturacion(anio,mesInicio,mesFin);
    };

    @PutMapping("/ajustarTarifaViaje/{nuevaTarifa}/{fecha}")
    public void ajustarTarifaViaje(@PathVariable("nuevaTarifa") int nuevaTarifa, @PathVariable("fecha") Date fecha){
        viajeService.ajustarTarifaViaje(nuevaTarifa,fecha);
    }

    @PutMapping("/ajustarTarifaPausa/{nuevaTarifa}/{fecha}")
    public void ajustarTarifaPausa(@PathVariable("nuevaTarifa") int nuevaTarifa, @PathVariable("fecha")  Date fecha){
        viajeService.ajustarTarifaPausa(nuevaTarifa,fecha);
    }

}
