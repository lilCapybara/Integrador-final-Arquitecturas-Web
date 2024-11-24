package edu.unicen.exa.microserviciomonopatin.dtos;

import edu.unicen.exa.microserviciomonopatin.Entities.GPS;
import edu.unicen.exa.microservicioparada.Entities.Parada;
import edu.unicen.exa.microservicioviaje.Entities.Viaje;

public class MonopatinDTO {

    int idMonopatin;

    int horasDeUso;

    int Kilometraje;

    String estado;

    Viaje viajeActual;

    Boolean pausa;

    int contadorPausa;

    GPS gps;

    private Parada paradaActual;

    public MonopatinDTO(int idMonopatin, int kilometraje) { //Puede usarse tanto para generar el reporte por kilometraje
        this.idMonopatin = idMonopatin;                     //como por horas de uso, ya que la signatura es la misma
        this.horasDeUso = kilometraje;
    }




}
