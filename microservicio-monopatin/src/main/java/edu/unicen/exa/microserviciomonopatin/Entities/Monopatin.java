package edu.unicen.exa.microserviciomonopatin.Entities;

import edu.unicen.exa.microservicioparada.Entities.Parada;
import edu.unicen.exa.microservicioviaje.Entities.Viaje;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Monopatin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMonopatin;

    int horasDeUso;

    int kilometraje;

    String estado;  //Puede ser "Operativo" o "En mantenimiento"

    @OneToOne
    Viaje viajeActual;

    Boolean pausa;

    int contadorPausa;

    @OneToOne
    GPS gps;

    @ManyToOne
    private Parada paradaActual;

    public int getPosX(){
        return this.gps.getPosActualX();
    }

    public int getPosY(){
        return this.gps.getPosActualY();
    }

    public int getIdMonopatin() {
        return idMonopatin;
    }
}
