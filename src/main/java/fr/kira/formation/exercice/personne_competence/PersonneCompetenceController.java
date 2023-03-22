package fr.kira.formation.exercice.personne_competence;

public class PersonneCompetenceController {
    PersonneCompetenceService personneCompetenceService;

    public PersonneCompetenceController(PersonneCompetenceService personneCompetenceService) {
        this.personneCompetenceService = personneCompetenceService;
    }
}
