package fr.kira.formation.exercice.competences;

import fr.kira.formation.exercice.utils.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService extends CRUDService<Competence> {
    public CompetenceService(CompetenceRepository competenceRepository) {
        super(competenceRepository);
    }
}
