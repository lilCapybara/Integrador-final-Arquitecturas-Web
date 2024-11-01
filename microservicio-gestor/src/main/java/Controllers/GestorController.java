package Controllers;

import Entities.Gestor;
import Entities.Monopatin;
import Entities.Parada;
import Services.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("quitarParada/{idParada}")
    public ResponseEntity<Void> quitarParada(@PathVariable int idParada) {
        gestorService.borrarParada(idParada);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ubicarMonopatinEnParada/{idMonopatin}/{idParada}")
    public ResponseEntity<Void> ubicarMonopatinEnParada(@PathVariable int idMonopatin, int idParada){
        gestorService.ubicarMonopatin(idMonopatin,idParada);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void>iniciarMantenimientoMonopatin(int idMonopatin){
        gestorService.iniciarMantenimientoMonopatin(idMonopatin);
    }

    public ResponseEntity<Void>finalizarMantenimientoMonopatin(int idMonopatin){
        gestorService.finalizarMantenimientoMonopatin(idMonopatin);
    }

    List<MonopatinDTO> getMonopatinesOperativosYMantenimiento(){
    }
}
