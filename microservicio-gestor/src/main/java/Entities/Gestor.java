package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Gestor {
    @Id
    private Long idGestor;

    @OneToMany
    private List<Monopatin> flotaDeMonopatines;

    @OneToMany
    private List<Parada> listaDeParadas;

    @OneToMany
    private List<Viaje> listaDeViajes;
}
