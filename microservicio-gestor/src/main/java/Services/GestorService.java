package Services;

import Entities.Monopatin;
import Entities.Parada;
import Repositories.GestorMantenimientoRepository;
import Repositories.GestorMonopatinRepository;
import Repositories.GestorParadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestorService {
    @Autowired
    private GestorMonopatinRepository gestorMonopatinRepository;
    @Autowired
    private GestorParadaRepository gestorParadaRepository;
    @Autowired
    private GestorMantenimientoRepository gestorMantenimientoRepository;

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
        gestorMonopatinRepository.ubicarMonopatin(idMonopatin,idParada);
    }

    @Transactional
    public void iniciarMantenimientoMonopatin(int idMonopatin) {
        gestorMantenimientoRepository.iniciarMantenimiento(idMonopatin,"En mantenimiento");
    }

    @Transactional
    public void finalizarMantenimientoMonopatin(int idMonopatin) {
        gestorMantenimientoRepository.finalizarMantenimiento(idMonopatin,"En circulacion");
    }
}
