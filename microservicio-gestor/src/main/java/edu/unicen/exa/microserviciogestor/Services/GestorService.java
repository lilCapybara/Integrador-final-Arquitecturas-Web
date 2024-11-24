package edu.unicen.exa.microserviciogestor.Services;

import edu.unicen.exa.microserviciogestor.Entities.Gestor;
import Entities.Monopatin;
import Entities.Parada;
import edu.unicen.exa.microserviciogestor.FeignClients.MonopatinFeign;
import edu.unicen.exa.microserviciogestor.FeignClients.ParadaFeign;
import edu.unicen.exa.microserviciogestor.FeignClients.UsuarioFeign;
import edu.unicen.exa.microserviciogestor.FeignClients.ViajeFeign;
import edu.unicen.exa.microserviciogestor.Repositories.GestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class GestorService {

    @Autowired
    private GestorRepository gestorRepository;
    @Autowired
    private UsuarioFeign usuarioFeign;
    @Autowired
    private MonopatinFeign monopatinFeign;
    @Autowired
    private ViajeFeign viajeFeign;
    @Autowired
    private ParadaFeign paradaFeign;


    @Transactional
    public Gestor insertarGestor(Gestor gestor) {
        return gestorRepository.save(gestor);
    }

    @Transactional
    public void borrarGestor(int idGestor) {
        gestorRepository.deleteById(idGestor);
    }

    @Transactional
    public void modificarGestor(int idGestor, Gestor nuevoGestor) {
        Gestor gestorAModificar = gestorRepository.findById(idGestor).get();

        gestorAModificar.setNombreGestor(nuevoGestor.getNombreGestor());
        gestorAModificar.setApellidoGestor(nuevoGestor.getNombreGestor());
        gestorRepository.save(gestorAModificar);
    }

    @Transactional
    public Gestor getGestor(int idGestor) {
        return gestorRepository.findById(idGestor).get();
    }


    @Transactional
    public Monopatin insertarMonopatin(Monopatin monopatin) {
        return monopatinFeign.insertarMonopatin(monopatin);
    }

    @Transactional
    public void borrarMonopatin(int idMonopatin) {
        monopatinFeign.borrarMonopatin(idMonopatin);
    }

    @Transactional
    public Parada insertarParada(Parada parada) {
        return paradaFeign.insertarParada(parada);
    }

    @Transactional
    public void borrarParada(int idParada) {
        paradaFeign.borrarParada(idParada);
    }


    @Transactional
    public void ubicarMonopatin(int idMonopatin, int idParada) {
        monopatinFeign.ubicarMonopatin(idMonopatin,idParada);
    }

    @Transactional
    public void iniciarMantenimientoMonopatin(int idMonopatin) {
        monopatinFeign.iniciarMantenimientoMonopatin(idMonopatin);
    }

    @Transactional
    public void finalizarMantenimientoMonopatin(int idMonopatin, int idParada) {
        monopatinFeign.finalizarMantenimientoMonopatin(idMonopatin,idParada);
        monopatinFeign.ubicarMonopatin(idMonopatin,idParada);
    }


    //Servicios pedidos en la consigna

    // 3a) Genera reportes de uso con o sin tiempos de pausa
    @Transactional
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
    @Transactional
    public double getFacturacion(Date anio,Date mesInicio, Date mesFin) {
        return viajeFeign.getFacturacion(anio,mesInicio,mesFin);
    }

    // 3e) Muestra la cantidad de monopatines en operacion y en mantenimiento
    @Transactional
    public List<Object[]> getMonopatinesOperativosYMantenimiento() {
        return monopatinFeign.getMonopatinesOperativosYMantenimiento();
    }

    // 3f) Funciones utilizadas para actualizar tarifas de viaje y de pausa
    @Transactional
    public void ajustarTarifaViaje(int nuevaTarifa, Date fecha) {
        viajeFeign.ajustarTarifaViaje(nuevaTarifa, fecha);
    }

    @Transactional
    public void ajustarTarifaPausa(int nuevaTarifa, Date fecha) {
        viajeFeign.ajustarTarifaPausa(nuevaTarifa, fecha);
    }

}
