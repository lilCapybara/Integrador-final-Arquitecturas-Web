package Entities;

import jakarta.persistence.*;

@Entity
public class Monopatin {

@Id
int idMonopatin;

int horasDeUso;

int Kilometraje;

Viaje viajeActual;

Boolean pausa;

int contadorPausa;

@OneToOne
GPS gps;

}
