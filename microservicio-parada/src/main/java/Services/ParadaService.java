package Services;

import Entities.Parada;
import Repositories.ParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParadaService {

    private static ParadaRepository paradaRepository;

    public Parada insertarParada(Parada parada) {
        return paradaRepository.save(parada);
    }

    public void borrarParada(int idParada) {
        paradaRepository.deleteById(idParada);
    }

    public Parada modificarParada(int idParada, Parada paradaActualizda) {
        Parada paradaAModificar = paradaRepository.findById(idParada).get();

        paradaAModificar.setPosX(paradaActualizda.getPosX());
        paradaAModificar.setPosY(paradaActualizda.getPosY());

        return paradaRepository.save(paradaAModificar);
    }

    public static Optional<Parada> encontrarPorId(int idParada) {
        return paradaRepository.findById(idParada);
    }
}
