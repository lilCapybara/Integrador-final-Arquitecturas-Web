package Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Parada {

    @Id
    private int idParada;

    private int posX;

    private int posY;

    @OneToMany(mappedBy = "paradaActual")
    private List<Monopatin> monopatinesEnParada;

}
