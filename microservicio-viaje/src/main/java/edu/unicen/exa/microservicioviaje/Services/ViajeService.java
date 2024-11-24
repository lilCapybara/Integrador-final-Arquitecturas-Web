package edu.unicen.exa.microservicioviaje.Services;

import edu.unicen.exa.microservicioviaje.Entities.Viaje;
import edu.unicen.exa.microservicioviaje.Repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public double getFacturacion(Date anio, Date mesInicio, Date mesFin) {
        return viajeRepository.getFacturacion(anio,mesInicio,mesFin);
    }

    public void ajustarTarifaViaje(int nuevaTarifa, Date fecha) {
        viajeRepository.ajustarTarifaViaje(nuevaTarifa, fecha);
    }

    public void ajustarTarifaPausa(int nuevaTarifa, Date fecha) {
        viajeRepository.ajustarTarifaPausa(nuevaTarifa, fecha);
    }
}
