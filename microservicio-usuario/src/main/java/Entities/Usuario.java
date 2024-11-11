package Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private int idUsuario;

    private String nickname;

    private String nombre;

    private String apellido;

    private int nroCelular;

    private String email;

    private Date fechaDeAlta;

    @ManyToOne
    private  Cuenta cuentaMP;

    private Boolean cuentaActiva;

    private Boolean pausaExtensa;

    @OneToOne
    private Monopatin monopatinEnUso;

    @Getter
    private int posX;

    @Getter
    private int posY;

}
