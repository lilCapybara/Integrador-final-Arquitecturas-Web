package edu.unicen.exa.microservicioviaje.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PrecioViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrecio;

    @Getter @Setter
    private int precioXKilometro;

    @Getter @Setter
    private int tarifaPausaExtensa;

    Date fechaAplicacion;

}
