package Services;

import Entities.Monopatin;
import Entities.Parada;
import FeignClients.UsuarioFeign;
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
    private GestorUsuarioRepository gestorUsuarioRepository;
    @Autowired
    private GestorViajeRepository gestorViajeRepository;
    @Autowired
    private UsuarioFeign usuarioFeign;

    private MonopatinRepository monopatinRepository;

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

    @Transactional
    public List<Object[]> getMonopatinesOperativosYMantenimiento() {
        return gestorMonopatinRepository.getMonopatinesOperativosYMantenimiento();
    }

    @Transactional
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(int cantViajes, int anio) {
        return gestorMonopatinRepository.getMonopatinesConMasDeXViajesXAnio(cantViajes,anio);
    }

    public List<Object[]> getReporteDeUso(boolean incluirPausas) {
        return gestorMonopatinRepository.getReporteDeUso(incluirPausas);
    }

    public void ajustarTarifaViaje(int nuevaTarifa, Date fecha) {
        gestorViajeRepository.setPrecioXKilometro(nuevaTarifa, fecha);
    }

    public void ajustarTarifaPausa(int nuevaTarifa, Date fecha) {
       gestorViajeRepository.setTarifaPausaExtensa(nuevaTarifa, fecha);
    }

    @Transactional
    public void cambiarEstadoUsuario(int idUsuario, boolean estado) {
        usuarioFeign.cambiarEstadoUsuario(idUsuario,estado);
    }

    public List<Object[]> getMonopatinesCercanos(int posUsuarioX, int posUsuarioY) {
        List<Monopatin> monopatines = monopatinRepository.findAll();
        double distanciaMinima = Double.MAX_VALUE;
        Map<Double, List<Monopatin>> distanciaMap = new HashMap<>();

        for (Monopatin monopatin : monopatines) {
            int posX = monopatin.getPosX();
            int posY = monopatin.getPosY();

            double distancia = calcularDistancia(posUsuarioX, posUsuarioY, posX, posY);

            // Actualiza el mapa de distancias
            distanciaMap.computeIfAbsent(distancia, k -> new ArrayList<>()).add(monopatin);

            // Mantiene la distancia mínima
            distanciaMinima = Math.min(distanciaMinima, distancia);
        }

        // Devuelve los monopatines que estan a la distancia minima obtenida
        return distanciaMap.getOrDefault(distanciaMinima, Collections.emptyList())
                .stream()
                .map(m -> new Object[]{m.getIdMonopatin(), m.getPosX(), m.getPosY()})
                .collect(Collectors.toList());
    }


    private double calcularDistancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double getFacturacion(Date mesInicio, Date mesFin) {
        return gestorViajeRepository.getFacturacion(mesInicio,mesFin);
    }
}
