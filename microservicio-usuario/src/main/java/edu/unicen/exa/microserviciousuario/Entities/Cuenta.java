package edu.unicen.exa.microserviciousuario.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuenta;

    private int saldo;

    @ManyToMany(mappedBy = "cuentas")
    private List<Usuario> usuarios;
}
