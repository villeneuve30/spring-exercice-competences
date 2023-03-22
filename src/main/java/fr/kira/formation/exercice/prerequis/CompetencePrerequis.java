package fr.kira.formation.exercice.prerequis;

import fr.kira.formation.exercice.competences.Competence;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompetencePrerequis {
    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    private Integer niveauRequis;
}