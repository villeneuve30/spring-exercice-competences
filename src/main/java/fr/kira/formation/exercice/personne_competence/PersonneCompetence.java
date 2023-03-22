package fr.kira.formation.exercice.personne_competence;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonneCompetence {
    @EmbeddedId
    PersonneCompetenceId id;

    private Integer niveau;
}

