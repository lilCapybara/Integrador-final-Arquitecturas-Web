package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Cuenta {
    @Id
    private int idCuenta;

    private int saldo;

    @ManyToMany(mappedBy = "cuentas")
    private List<Usuario> usuarios;
}
