package fr.kira.formation.exercice.personne_competence;

import fr.kira.formation.exercice.competences.Competence;
import fr.kira.formation.exercice.personnes.Personne;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PersonneCompetenceId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;
}
