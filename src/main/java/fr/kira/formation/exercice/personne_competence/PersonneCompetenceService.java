package fr.kira.formation.exercice.personne_competence;

import fr.kira.formation.exercice.utils.CRUDService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonneCompetenceService extends CRUDService<PersonneCompetence> {
    PersonneCompetenceRepository personneCompetenceRepository;
    public PersonneCompetenceService(PersonneCompetenceRepository personneCompetenceRepository) {
        super(personneCompetenceRepository);
    }
}
