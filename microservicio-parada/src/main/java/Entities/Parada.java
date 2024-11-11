package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Parada {

    @Id
    private int idParada;

    @Getter
    @Setter
    private int posX;

    @Getter @Setter
    private int posY;

}
