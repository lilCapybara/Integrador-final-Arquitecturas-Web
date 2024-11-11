package Services;

import Entities.Viaje;
import Repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViajeService {
    @Autowired
    private ViajeRepository viajeRepository;

    public Viaje insertarViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public void borrarViaje(int idViaje) {
        viajeRepository.deleteById(idViaje);
    }

    public Viaje modificarViaje(int idViaje, Viaje viajeActualizado) {
        Viaje viajeAModificar = viajeRepository.findById(idViaje).get();

        viajeAModificar.setParadaOrigen(viajeActualizado.getParadaOrigen());
        viajeAModificar.setParadaDestino(viajeActualizado.getParadaDestino());
        viajeAModificar.setTiempoDeViaje(viajeActualizado.getTiempoDeViaje());
        viajeAModificar.setKilometrosRecorridos(viajeActualizado.getKilometrosRecorridos());
        viajeAModificar.setFechaFinalizacion(viajeActualizado.getFechaFinalizacion());
        viajeAModificar.setFechaInicio(viajeActualizado.getFechaInicio());
        viajeAModificar.setHoraInicio(viajeActualizado.getHoraInicio());
        viajeAModificar.setHoraFinalizacion(viajeActualizado.getHoraFinalizacion());

        return viajeRepository.save(viajeAModificar);
    }

    public Optional<Viaje> encontrarPorId(int idViaje) {
        return viajeRepository.findById(idViaje);
    }
}
