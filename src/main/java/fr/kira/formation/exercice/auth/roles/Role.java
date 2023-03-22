package fr.kira.formation.exercice.auth.roles;

import fr.kira.formation.exercice.prerequis.Prerequis;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Long id;
    private String authority;

    @ManyToOne
    @JoinColumn(name = "prerequis_id")
    private Prerequis prerequis = new Prerequis();

    public Role(String authority) {
        this.authority = authority;
    }
}