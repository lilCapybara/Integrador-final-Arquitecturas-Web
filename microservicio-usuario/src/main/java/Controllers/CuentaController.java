package Controllers;

import Entities.Cuenta;
import Services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/microservicioUsuario/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;


    @PostMapping("/agregarCuenta")
    public ResponseEntity<Cuenta> agregarCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.agregarCuenta(cuenta);
        return ResponseEntity.ok().body(nuevaCuenta);
    }

    @GetMapping("/getCuenta/{idCuenta}")
    public ResponseEntity<Cuenta> getCuenta(@PathVariable int idCuenta) {
        cuentaService.getCuenta(idCuenta);
    }

    @DeleteMapping("/borrarCuenta/{idCuenta}")
    public ResponseEntity<Void> borrarCuenta(@PathVariable int idCuenta) {
        cuentaService.borrarCuenta(idCuenta);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificarCuenta/{idCuenta}")
    public ResponseEntity<Void> modificarCuenta(@PathVariable int idCuenta, @RequestBody Cuenta nuevaCuenta) {
        cuentaService.modificarCuenta(idCuenta, nuevaCuenta);
        return ResponseEntity.noContent().build();
    }


}
