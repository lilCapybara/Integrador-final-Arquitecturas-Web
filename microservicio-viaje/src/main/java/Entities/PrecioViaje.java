package Entities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class PrecioViaje {

    private int idPrecio;

    @Getter
    @Setter
    private int precioXKilometro;

    @Getter @Setter
    private int tarifaPausaExtensa;

    public PrecioViaje(int precioXKilometro, int tarifaPausaExtensa) {
        this.precioXKilometro = precioXKilometro;
        this.tarifaPausaExtensa = tarifaPausaExtensa;
    }

    public static void setPrecioXKilometro(int precioXKilometro) {
        this.precioXKilometro = precioXKilometro;
    }

    public static void setTarifaPausaExtensa(int tarifaPausaExtensa) {
        this.tarifaPausaExtensa = tarifaPausaExtensa;
    }
}
