package fr.kira.formation.exercice.personnes;

import fr.kira.formation.exercice.competences.Competence;
import fr.kira.formation.exercice.competences.CompetenceService;
import fr.kira.formation.exercice.personne_competence.PersonneCompetence;
import fr.kira.formation.exercice.personne_competence.PersonneCompetenceId;
import fr.kira.formation.exercice.prerequis.CompetencePrerequis;
import fr.kira.formation.exercice.prerequis.Prerequis;
import fr.kira.formation.exercice.utils.CRUDService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonneService extends CRUDService<Personne> {

    private final PersonneRepository personneRepository;

    private final CompetenceService competenceService;

    public PersonneService(PersonneRepository personneRepository, CompetenceService competenceService) {
        super(personneRepository);
        this.personneRepository = personneRepository;
        this.competenceService = competenceService;
    }

    public List<Personne> findByNom(String nom) {
        return personneRepository.findByNom(nom);
    }

    public List<Personne> findByPrenom(String prenom) {
        return personneRepository.findByPrenom(prenom);
    }

    @Transactional
    public void ajouterCompetence(Personne personne, Competence competence, Integer niveau) {
        Personne personneBdd = findById(personne.getId());
        Competence competenceBdd = competenceService.findById(competence.getId());

        // Vérifier si la compétence a un prérequis
        Prerequis prerequis = competenceBdd.getPrerequis();
        if (prerequis != null) {
            for (CompetencePrerequis competencePrerequis : prerequis.getCompetencesPrerequises()) {
                Integer niveauRequis = competencePrerequis.getNiveauRequis();
                Competence competenceRequise = competencePrerequis.getCompetence();
                if (!this.aCompetenceAvecNiveau(personneBdd.getCompetencesAcquises(), competenceRequise, niveauRequis)) {
                    throw new RuntimeException("Prérequis non respecté : la compétence " + competenceRequise.getNom() + " est requise au niveau " + niveauRequis);
                }
            }
        }

        PersonneCompetence nouvelleCompetence = new PersonneCompetence();
        nouvelleCompetence.setId(new PersonneCompetenceId(personneBdd, competenceBdd));
        nouvelleCompetence.setNiveau(niveau);

        personneBdd.getCompetencesAcquises().add(nouvelleCompetence);

        save(personneBdd);
    }

    public boolean aCompetenceAvecNiveau(Set<PersonneCompetence> competences, Competence competenceRecherchee, Integer niveauRecherche) {
        for (PersonneCompetence pc : competences) {
            if (pc.getId().getCompetence().equals(competenceRecherchee) && pc.getNiveau() >= niveauRecherche) {
                return true;
            }
        }
        return false;
    }
}
