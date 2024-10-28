package Entities;

import java.util.Date;

@Entity
public class Usuario {
    @id
    int idUsuario;

    String nickname;

    String nombre;

    String apellido;

    int nroCelular;

    String email;

    Date fechaDeAlta;

    Cuenta cuentaMP;

    Boolean cuentaActiva;

    Monopatin monopatinEnUso;

}
