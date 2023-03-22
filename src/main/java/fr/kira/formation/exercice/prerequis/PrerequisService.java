package fr.kira.formation.exercice.prerequis;

import fr.kira.formation.exercice.utils.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class PrerequisService extends CRUDService<Prerequis> {

    PrerequisRepository prerequisRepository;
    public PrerequisService(PrerequisRepository prerequisRepository) {
        super(prerequisRepository);
    }
}
