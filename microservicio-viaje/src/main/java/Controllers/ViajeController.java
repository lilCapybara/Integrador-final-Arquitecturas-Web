package Controllers;

import Entities.Viaje;
import Services.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/microservicioViaje/Viaje")
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
}
