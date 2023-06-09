package fr.kira.formation.exercice.personnes;


import fr.kira.formation.exercice.auth.roles.Role;
import fr.kira.formation.exercice.equipes.Equipe;
import fr.kira.formation.exercice.personne_competence.PersonneCompetence;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personne_id", nullable = false)
    private Long id;

    private String nom;

    private String prenom;

    private Boolean isManager;

    private String username;
    private String password;

    @ManyToMany
    @ToString.Exclude
    private List<Role> roles = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    private LocalDateTime dateCreation = LocalDateTime.now();

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "personne_id", referencedColumnName = "personne_id"),
            @JoinColumn(name = "competence_id", referencedColumnName = "competence_id")
    })
    private HashSet<PersonneCompetence> competencesAcquises = new HashSet<>();
}
