package edu.unicen.exa.gateway.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private String username;

    @Column( nullable = false )
    private String password;

    @JsonIgnore //Es recomendable usar FetchType.LAZY para que traiga la lista de autoridades solo si se la pide
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )    //Es ManyToMany ya que un usuario puede ser admin y alumno
    @JoinTable(                                                             //y admin pueden ser varios usuarios
            name = "user_authority",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "name") }
    )
    private Set<Authority> authorities = new HashSet<>();

    public User( final String username ) {
        this.username = username.toLowerCase();
    }

    public void setAuthorities( final Collection<Authority> authorities ) {
        this.authorities = new HashSet<>( authorities );
    }
}

