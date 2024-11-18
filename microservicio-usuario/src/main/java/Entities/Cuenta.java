package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Cuenta {
    @Id
    private int idCuenta;

    private int saldo;

    @ManyToMany(mappedBy = "cuentas") // Referencia al atributo en Usuario
    private List<Usuario> usuarios;
}
