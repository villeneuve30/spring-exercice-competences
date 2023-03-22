package fr.kira.formation.exercice.equipes;

import fr.kira.formation.exercice.personnes.Personne;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "equipe")
    private List<Personne> membres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "representant_id")
    private Personne representant;
}
