package Controllers;

import Services.GestorService;
import Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/microservicioUsuario/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private GestorService gestorService;

    public

    @GetMapping("/monopatinesCercanos/{posX}/{posY}")
    public ResponseEntity<List<Object[]>> getMonopatinesCercanos(@PathVariable int posX, @PathVariable int posY) {
        List<Object[]> listaDeMonopatines = usuarioService.getMonopatinesCercanos(posX,posY);
        return ResponseEntity.ok(listaDeMonopatines);
    }
}
