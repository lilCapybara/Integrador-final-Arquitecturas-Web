package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Getter @Setter
    private String nickname;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellido;

    @Getter @Setter
    private int nroCelular;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private Date fechaDeAlta;

    @ManyToMany
    @JoinTable(
            name = "usuario_cuenta",
            joinColumns = @JoinColumn(name = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name = "idCuenta")
    )
    private List<Cuenta> cuentasMP;

    @Getter @Setter
    @Column(columnDefinition = "boolean default true")
    private Boolean cuentaActiva;

    @Getter @Setter
    private Boolean pausaExtensa;

    @Getter @Setter
    @OneToOne
    private Monopatin monopatinEnUso;

    @Getter @Setter
    private int posX;

    @Getter @Setter
    private int posY;

}
