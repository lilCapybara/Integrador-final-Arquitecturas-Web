package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    private int id;

    private int saldo;
}
