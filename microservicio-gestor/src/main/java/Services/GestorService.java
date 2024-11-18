package Services;

import Entities.Monopatin;
import Entities.Parada;
import FeignClients.MonopatinFeign;
import FeignClients.UsuarioFeign;
import FeignClients.ViajeFeign;
import Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GestorService {
    @Autowired
    private GestorMonopatinRepository gestorMonopatinRepository;
    @Autowired
    private GestorParadaRepository gestorParadaRepository;
    @Autowired
    private GestorMantenimientoRepository gestorMantenimientoRepository;
    @Autowired
    private UsuarioFeign usuarioFeign;
    @Autowired
    private MonopatinFeign monopatinFeign;
    @Autowired
    private ViajeFeign viajeFeign;


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
        gestorMonopatinRepository.enviarATaller(idMonopatin);
    }

    @Transactional
    public void finalizarMantenimientoMonopatin(int idMonopatin, int idParada) {
        gestorMantenimientoRepository.finalizarMantenimiento(idMonopatin,"En circulacion");
        gestorMonopatinRepository.ubicarMonopatin(idMonopatin,idParada);
    }


    //Servicios pedidos en la consigna

    // 3a) Genera reportes de uso con o sin tiempos de pausa
    public List<Object[]> getReporteDeUso(boolean incluirPausas) {
        return monopatinFeign.getReporteDeUso(incluirPausas);
    }

    // 3b) Funcion utilizada para anular cuentas de usuario
    @Transactional
    public void cambiarEstadoUsuario(int idUsuario, boolean estado) {
        usuarioFeign.cambiarEstadoUsuario(idUsuario,estado);
    }

    // 3c) Me da una lista de los monopatines que tengan mas de x viajes en cierto año
    @Transactional
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(int cantViajes, int anio) {
        return monopatinFeign.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
    }

    // 3d) Me da la cantidad facturada entre dos meses de cierto año
    public double getFacturacion(Date anio,Date mesInicio, Date mesFin) {
        return viajeFeign.getFacturacion(anio,mesInicio,mesFin);
    }

    // 3e) Muestra la cantidad de monopatines en operacion y en mantenimiento
    @Transactional
    public List<Object[]> getMonopatinesOperativosYMantenimiento() {
        return monopatinFeign.getMonopatinesOperativosYMantenimiento();
    }

    // 3f) Funciones utilizadas para actualizar tarifas de viaje y de pausa
    public void ajustarTarifaViaje(int nuevaTarifa, Date fecha) {
        viajeFeign.ajustarTarifaViaje(nuevaTarifa, fecha);
    }

    public void ajustarTarifaPausa(int nuevaTarifa, Date fecha) {
        viajeFeign.ajustarTarifaPausa(nuevaTarifa, fecha);
    }


}
