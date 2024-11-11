package Entities;

import jakarta.persistence.*;

@Entity
public class Monopatin {

    @Id
    int idMonopatin;

    int horasDeUso;

    int kilometraje;

    String estado;  //Puede ser "Operativo" o "En mantenimiento"

    @OneToOne
    Viaje viajeActual;

    Boolean pausa;

    int contadorPausa;

    @OneToOne
    GPS gps;

    @ManyToOne
    private Parada paradaActual;

    public int getPosX(){
        return this.gps.getPosActualX();
    }

    public int getPosY(){
        return this.gps.getPosActualY();
    }
}
