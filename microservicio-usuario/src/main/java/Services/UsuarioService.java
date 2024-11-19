package Services;

import Entities.Cuenta;
import Entities.Monopatin;
import Entities.Usuario;
import Entities.Viaje;
import FeignClients.MonopatinFeign;
import FeignClients.ViajeFeign;
import Repositories.MonopatinRepository;
import Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private MonopatinFeign monopatinFeign;

    private ViajeFeign viajeFeign;

    private CuentaService cuentaService;


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

    public ResponseEntity<Viaje> cerrarViaje(Viaje viaje) {
        return viajeFeign.agregarViaje(viaje);
    }

    //Servicios pedidos en la consigna

    // 3b) Funcion utilizada para anular cuentas de usuario
    public void cambiarEstadoUsuario(int idUsuario, boolean estado) {
        Usuario usuarioAModificar=usuarioRepository.findById(idUsuario).get();

        usuarioAModificar.setCuentaActiva(estado);
        usuarioRepository.save(usuarioAModificar);
    }

    // 3g) Obtiene un listado de los monopatines mas cercanos a la posicion (x,y) del usuario
    public List<Object[]> getMonopatinesCercanos(int idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        int posUsuarioX=usuario.getPosX();
        int posUsuarioY=usuario.getPosY();
        return monopatinFeign.getMonopatinesCercanos(posUsuarioX,posUsuarioY);
    }



}
