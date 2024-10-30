package Entities;

import jakarta.persistence.*;

@Entity
public class Parada {

    @Id
    private int idParada;

    private int posX;

    private int posY;

}
