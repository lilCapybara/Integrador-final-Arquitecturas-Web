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

    private int tiempoExcedido;

    private boolean pausaExtensa;

    private Date fechaInicio;

    private Date horaInicio;

    private Date fechaFinalizacion;

    private Date horaFinalizacion;

    @Transient
    private PrecioViaje precioViaje;

    private double precioTotal=this.getPrecio();

    public Viaje(Parada paradaOrigen, Parada paradaDestino, int kilometrosRecorridos, int tiempoDeViaje, Date fechaInicio, Date horaInicio, Date fechaFinalizacion, Date horaInicializacion, PrecioViaje precioViaje) {
        this.paradaOrigen = paradaOrigen;
        this.paradaDestino = paradaDestino;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.tiempoDeViaje = tiempoDeViaje;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.horaFinalizacion = horaInicializacion;
        this.precioViaje=precioViaje;
    }

    public Viaje() {}

    public double getPrecio(){
        double precio = 0;
        if (this.pausaExtensa) {
            precio = (this.kilometrosRecorridos * this.precioViaje.getPrecioXKilometro()) + (this.tiempoExcedido * this.precioViaje.getTarifaPausaExtensa());
        } else {
            precio = (this.kilometrosRecorridos * this.precioViaje.getPrecioXKilometro());
        }
        return precio;
    }

    public Parada getParadaOrigen() {
        return paradaOrigen;
    }

    public void setParadaOrigen(Parada paradaOrigen) {
        this.paradaOrigen = paradaOrigen;
    }

    public Parada getParadaDestino() {
        return paradaDestino;
    }

    public void setParadaDestino(Parada paradaDestino) {
        this.paradaDestino = paradaDestino;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public int getTiempoDeViaje() {
        return tiempoDeViaje;
    }

    public void setTiempoDeViaje(int tiempoDeViaje) {
        this.tiempoDeViaje = tiempoDeViaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Date getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(Date horaInicializacion) {
        this.horaFinalizacion = horaInicializacion;
    }
}
