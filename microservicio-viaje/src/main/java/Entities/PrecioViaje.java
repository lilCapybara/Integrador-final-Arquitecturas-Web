package Entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class PrecioViaje {

    private int idPrecio;

    @Getter

    private int precioXKilometro;

    @Getter
    private int tarifaPausaExtensa;

    public PrecioViaje(int precioXKilometro, int tarifaPausaExtensa) {
        this.precioXKilometro = precioXKilometro;
        this.tarifaPausaExtensa = tarifaPausaExtensa;
    }

    public void setPrecioXKilometro(int precioXKilometro) {
        this.precioXKilometro = precioXKilometro;
    }

    public void setTarifaPausaExtensa(int tarifaPausaExtensa) {
        this.tarifaPausaExtensa = tarifaPausaExtensa;
    }
}
