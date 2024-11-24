package edu.unicen.exa.microservicioparada.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParada;


    private int posX;


    private int posY;


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
