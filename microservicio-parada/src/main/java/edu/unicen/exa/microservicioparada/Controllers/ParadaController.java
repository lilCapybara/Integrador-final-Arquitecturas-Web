package edu.unicen.exa.microservicioparada.Controllers;

import edu.unicen.exa.microservicioparada.Entities.Parada;
import edu.unicen.exa.microservicioparada.Services.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/microservicioParada/")
public class ParadaController {
    @Autowired
    private ParadaService paradaService;

    @GetMapping("/encontrarPorId/{idParada}")
    public ResponseEntity<Optional<Parada>> encontrarPorId(@PathVariable int idParada) {
        Optional<Parada> nuevaParada = ParadaService.encontrarPorId(idParada);
        return ResponseEntity.ok().body(nuevaParada);
    }

    @PostMapping("/agregarParada")
    public ResponseEntity<Parada> agregarUsuario(@RequestBody Parada parada) {
        Parada nuevaParada = paradaService.insertarParada(parada);
        return ResponseEntity.ok(nuevaParada);
    }

    @DeleteMapping("/quitarParada/{idParada}")
    public ResponseEntity<Void> quitarParada(@PathVariable int idParada){
        paradaService.borrarParada(idParada);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificarParada/{idParada}")
    public ResponseEntity<Parada> modificarParada(@PathVariable int idParada, @RequestBody Parada parada){
        Parada paradaModificada = paradaService.modificarParada(idParada,parada);
        return ResponseEntity.ok(paradaModificada);
    }
}
