package edu.unicen.exa.microservicioparada.Services;

import edu.unicen.exa.microservicioparada.Entities.Parada;
import edu.unicen.exa.microservicioparada.Repositories.ParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParadaService {

    @Autowired
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
