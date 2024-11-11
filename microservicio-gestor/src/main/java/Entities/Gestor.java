package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Gestor {
    @Id
    private Long idGestor;
    private List<Monopatin> flotaDeMonopatines;
    private List<Parada> listaDeParadas;
    private List<Viaje> listaDeViajes;
}
