package Services;

import Entities.Monopatin;
import Entities.Parada;
import Repositories.GestorMonopatinRepository;
import Repositories.GestorParadaRepository;
import org.springframework.transaction.annotation.Transactional;

public class GestorService {
    private GestorMonopatinRepository gestorMonopatinRepository;
    private GestorParadaRepository gestorParadaRepository;

    @Transactional
    public Monopatin insertarMonopatin(Monopatin monopatin) {
        return gestorMonopatinRepository.save(monopatin);
    }

    @Transactional
    public void borrarMonopatin(int idMonopatin) {
        gestorMonopatinRepository.deleteById(idMonopatin);
    }

    @Transactional
    public Parada insertarParada(Parada parada) {
        return gestorParadaRepository.save(parada);
    }

    @Transactional
    public void borrarParada(int idParada) {
        gestorParadaRepository.deleteById(idParada);
    }

    @Transactional
    public void ubicarMonopatin(int idMonopatin, int idParada) {
        GestorParadaRepository.ubicarMonopatin(idMonopatin,idParada);
    }
}
