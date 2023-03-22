package fr.kira.formation.exercice.equipes;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Optional<Equipe> findByNom(String nom);

    List<Equipe> findAllByMembresId(Long byId);
}
