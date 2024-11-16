package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class PrecioViaje {

    @Id
    private int idPrecio;

    @Getter @Setter
    private int precioXKilometro;

    @Getter @Setter
    private int tarifaPausaExtensa;

    Date fechaAplicacion;

    public PrecioViaje(int precioXKilometro, int tarifaPausaExtensa, Date fechaAplicacion) {
        this.precioXKilometro = precioXKilometro;
        this.tarifaPausaExtensa = tarifaPausaExtensa;
        this.fechaAplicacion = fechaAplicacion;
    }

    public PrecioViaje() {

    }

}
