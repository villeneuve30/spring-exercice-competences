package fr.kira.formation.exercice.roles;

import fr.kira.formation.exercice.prerequis.Prerequis;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Long id;

    private String nom;

    private String description;

    @ManyToOne
    @JoinColumn(name = "prerequis_id")
    private Prerequis prerequis;
}
