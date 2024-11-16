package Entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class GPS {

    @Id
    private int idGPS;

    @Getter
    private int posActualX;

    @Getter
    private int posActualY;

}
