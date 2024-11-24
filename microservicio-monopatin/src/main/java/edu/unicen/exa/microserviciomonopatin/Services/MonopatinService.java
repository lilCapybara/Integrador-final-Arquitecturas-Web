package edu.unicen.exa.microserviciomonopatin.Services;

import edu.unicen.exa.microserviciomonopatin.Entities.Monopatin;

import edu.unicen.exa.microserviciomonopatin.Repositories.MonopatinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MonopatinService {

    @Autowired
    MonopatinRepository monopatinRepository;



    public Monopatin insertarMonopatin(Monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    public void borrarMonopatin(int idMonopatin) {
        monopatinRepository.deleteById(idMonopatin);
    }

    public void ubicarMonopatin(int idMonopatin, int idParada) {
        monopatinRepository.ubicarMonopatin(idMonopatin,idParada);
    }

    public void iniciarMantenimientoMonopatin(int idMonopatin) {
        monopatinRepository.iniciarMantenimiento(idMonopatin,"En mantenimiento");
        monopatinRepository.enviarATaller(idMonopatin);
    }

    public void finalizarMantenimientoMonopatin(int idMonopatin, int idParada) {
        monopatinRepository.finalizarMantenimiento(idMonopatin,"En circulacion");
        monopatinRepository.ubicarMonopatin(idMonopatin,idParada);
    }



    //Servicios pedidos en la consigna

    // 3a) Genera reportes de uso con o sin tiempos de pausa
    public List<Object[]> getReporteDeUso(boolean incluirPausas) {
        return monopatinRepository.getReporteDeUso(incluirPausas);
    }

    // 3c) Me da una lista de los monopatines que tengan mas de x viajes en cierto año
    public List<Object[]> getMonopatinesConMasDeXViajesXAnio(int cantViajes, int anio) {
        return monopatinRepository.getMonopatinesConMasDeXViajesXAnio(cantViajes, anio);
    }

    public List<Object[]>getMonopatinesOperativosYMantenimiento(){
        return monopatinRepository.getMonopatinesOperativosYMantenimiento();
    }

    // 3g) Obtiene un listado de los monopatines mas cercanos a la posicion (x,y) del usuario
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


}