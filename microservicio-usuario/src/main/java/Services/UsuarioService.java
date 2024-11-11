package Services;

import Entities.Monopatin;
import Entities.Usuario;
import Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private GestorService gestorService;

    public List<Monopatin> getMonopatinesCercanosAUsuario(int posX, int posY) {

        return gestorService.getMonopatinesCercanos(posX,posY);
    }

}
