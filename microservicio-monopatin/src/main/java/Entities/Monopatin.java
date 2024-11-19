package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
