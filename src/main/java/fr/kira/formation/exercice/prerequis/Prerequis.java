package fr.kira.formation.exercice.prerequis;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prerequis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prerequis_id", nullable = false)
    private Long id;
    private Set<CompetencePrerequis> competencesPrerequises = new HashSet<>();
    private Boolean validationParPair = false;
    private Boolean validationParManager = false;
    private Boolean validationParTest = false;
    private String urlDuTest = "";
}
