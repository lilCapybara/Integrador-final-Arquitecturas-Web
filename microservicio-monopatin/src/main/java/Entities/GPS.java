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
public class GPS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGPS;

    @Getter
    private int posActualX;

    @Getter
    private int posActualY;


}
