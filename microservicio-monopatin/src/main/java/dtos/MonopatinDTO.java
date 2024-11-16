package dtos;

import Entities.GPS;
import Entities.Parada;
import Entities.Viaje;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
