package Entities;

import jakarta.persistence.*;

@Entity
public class Monopatin {

@Id
int idMonopatin;

int horasDeUso;

int Kilometraje;

String estado;  //Puede ser "Operativo" o "En mantenimiento"

@OneToOne
Viaje viajeActual;

Boolean pausa;

int contadorPausa;

@OneToOne
GPS gps;

@ManyToOne
private Parada paradaActual;
}
