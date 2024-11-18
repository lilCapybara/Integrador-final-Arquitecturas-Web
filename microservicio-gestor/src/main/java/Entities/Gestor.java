package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestor;

    private String nombreGestor;

    private String apellidoGestor;

}
