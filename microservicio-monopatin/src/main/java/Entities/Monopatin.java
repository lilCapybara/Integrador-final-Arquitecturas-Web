package Entities;

import jakarta.persistence.*;

@Entity
public class Monopatin {

@Id
int idMonopatin;

int horasDeUso;

int Kilometraje;

String estado;

@OneToOne
Viaje viajeActual;

Boolean pausa;

int contadorPausa;

@OneToOne
GPS gps;

@ManyToOne
@JoinColumn(name = "idParada") // Esta columna hace referencia a la clave primaria en Parada
private Parada paradaActual;
}
