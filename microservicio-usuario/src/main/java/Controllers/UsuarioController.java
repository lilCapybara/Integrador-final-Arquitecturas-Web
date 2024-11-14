package Controllers;

import Entities.Usuario;
import Services.GestorService;
import Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/microservicioUsuario/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private GestorService gestorService;

    @GetMapping("/encontrarPorId/{idUsuario}")
    public ResponseEntity<Optional<Usuario>> encontrarPorId(@PathVariable int idUsuario) {
        Optional<Usuario> nuevoUsuario = usuarioService.encontrarPorId(idUsuario);
        return ResponseEntity.ok().body(nuevoUsuario);
    }

    @GetMapping("/agregarUsuario")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.insertarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping("/quitarUsuario/{idUsuario}")
    public ResponseEntity<Void> quitarUsuario(@PathVariable int idUsuario){
        usuarioService.borrarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/modificarUsuario/{idUsuario}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable int idUsuario, @RequestBody Usuario usuario){
        Usuario usuarioModificado = usuarioService.modificarUsuario(idUsuario,usuario);
        return ResponseEntity.ok(usuarioModificado);
    }

    @GetMapping("/monopatinesCercanos/{idUsuario}")
    public ResponseEntity<List<Object[]>> getMonopatinesCercanos(@PathVariable int idUsuario) {
        List<Object[]> listaDeMonopatines = usuarioService.getMonopatinesCercanos(idUsuario);
        return ResponseEntity.ok(listaDeMonopatines);
    }

    @PutMapping("/cambiarEstadoUsuario/{idUsuario}/{estado}")
    public ResponseEntity<Void> cambiarEstadoUsuario(@PathVariable int idUsuario, @PathVariable boolean estado) {
        usuarioService.cambiarEstadoUsuario(idUsuario,estado);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
