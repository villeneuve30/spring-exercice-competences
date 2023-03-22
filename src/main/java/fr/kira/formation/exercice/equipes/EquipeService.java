package fr.kira.formation.exercice.equipes;

import fr.kira.formation.exercice.personnes.PersonneService;
import fr.kira.formation.exercice.utils.CRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService extends CRUDService<Equipe> {

    EquipeRepository equipeRepository;
    PersonneService personneService;
    public EquipeService(EquipeRepository equipeRepository, PersonneService personneService) {
        super(equipeRepository);
        this.personneService = personneService;
    }

    // rechercher une équipe en fonction de son nom
    public Optional<Equipe> findByNom(String nom) {
        return equipeRepository.findByNom(nom);
    }

    // ajouter un membre à une équipe
    public Equipe addMembre(Long id, Long membreId) {
        Equipe equipe = findById(id);
        equipe.getMembres().add(personneService.findById(membreId));
        return save(equipe);
    }

    // supprimer un membre d'une équipe
    public Equipe removeMembre(Long id, Long membreId) {
        Equipe equipe = findById(id);
        equipe.getMembres().remove(personneService.findById(membreId));
        // equipe.getMembres().removeIf(personne -> personne.getId().equals(membreId));
        return save(equipe);
    }

    // modifier le représentant d'une équipe
    public Equipe updateRepresentant(Long id, Long representantId) {
        Equipe equipe = findById(id);
        equipe.setRepresentant(personneService.findById(representantId));
        return save(equipe);
    }

    // Récupérer les équipes d'un membre
    public List<Equipe> findByMembre(Long membreId) {
        personneService.findById(membreId);
        return equipeRepository.findAllByMembresId(membreId);
    }
}
