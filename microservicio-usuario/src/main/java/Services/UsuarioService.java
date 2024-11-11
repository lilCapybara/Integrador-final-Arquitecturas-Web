package Services;

import Entities.Monopatin;
import Entities.Usuario;
import Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private GestorService gestorService;

    public List<Monopatin> getMonopatinesCercanosAUsuario(int posX, int posY) {

        return gestorService.getMonopatinesCercanos(posX,posY);
    }

    public Usuario insertarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void borrarUsuario(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario modificarUsuario(int idUsuario, Usuario usuarioActualizado) {
        Usuario usuarioAModificar = usuarioRepository.findById(idUsuario).get();

        usuarioAModificar.setNickname(usuarioActualizado.getNickname());
        usuarioAModificar.setNombre(usuarioActualizado.getNombre());
        usuarioAModificar.setApellido(usuarioActualizado.getApellido());
        usuarioAModificar.setEmail(usuarioActualizado.getEmail());
        usuarioAModificar.setNroCelular(usuarioActualizado.getNroCelular());
        return usuarioRepository.save(usuarioAModificar);
    }

    public Optional<Usuario> encontrarPorId(int idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
}
