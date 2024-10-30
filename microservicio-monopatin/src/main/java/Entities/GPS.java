package Entities;

import jakarta.persistence.*;

@Entity
public class GPS {

    @Id
    private int idGPS;

    private int posActualX;

    private int posActualY;
}
