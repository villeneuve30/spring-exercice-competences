package fr.kira.formation.exercice.personnes;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    List<Personne> findByNom(String nom);

    List<Personne> findByPrenom(String prenom);

    Personne findByUsername(String username);
}
