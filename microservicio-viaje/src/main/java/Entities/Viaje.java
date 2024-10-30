package Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Viaje {

    @Id
    private int idViaje;

    @OneToOne
    private Parada paradaOrigen;

    @OneToOne
    private Parada paradaDestino;

    private int kilometrosRecorridos;

    private int tiempoDeViaje;

    private int precioXKilometro;

    private int tarifaPausaExtensa;

    private Date fechaInicio;

    private Date horaInicio;

    private Date fechaFinalizacion;

    private Date horaInicializacion;
}
