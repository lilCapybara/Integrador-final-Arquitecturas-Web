package edu.unicen.exa.microservicioviaje.Entities;


import edu.unicen.exa.microservicioparada.Entities.Parada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idViaje;

    @OneToOne
    private Parada paradaOrigen;

    @OneToOne
    private Parada paradaDestino;

    private int kilometrosRecorridos;

    private int tiempoDeViaje;

    private int tiempoExcedido;

    private boolean pausaExtensa;

    private Date fechaInicio;

    private Date horaInicio;

    private Date fechaFinalizacion;

    private Date horaFinalizacion;

    @Transient
    private PrecioViaje precioViaje;

    private double precioTotal=this.getPrecio();


    public double getPrecio(){
        double precio = 0;
        if (this.pausaExtensa) {
            precio = (this.kilometrosRecorridos * this.precioViaje.getPrecioXKilometro()) + (this.tiempoExcedido * this.precioViaje.getTarifaPausaExtensa());
        } else {
            precio = (this.kilometrosRecorridos * this.precioViaje.getPrecioXKilometro());
        }
        return precio;
    }

}
