package fr.kira.formation.exercice.equipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @PostMapping("/")
    public @ResponseBody Equipe save(@RequestBody Equipe equipe) {
        System.out.println("test");
        return equipeService.save(equipe);
    }

    @GetMapping("/{id}")
    public Equipe findById(@PathVariable Long id) {
        return equipeService.findById(id);
    }

    @GetMapping("/")
    public List<Equipe> findAll() {
        return equipeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        equipeService.deleteById(id);
    }

    // rechercher une équipe en fonction de son nom
    @GetMapping("/nom/{nom}")
    public Equipe findByNom(@PathVariable String nom) {
        return equipeService.findByNom(nom).orElseThrow();
    }

    // ajouter un membre à une équipe
    @PutMapping("/{id}/membres/{membreId}")
    public Equipe addMembre(@PathVariable Long id, @PathVariable Long membreId) {
        return equipeService.addMembre(id, membreId);
    }

    // supprimer un membre d'une équipe
    @DeleteMapping("/{id}/membres/{membreId}")
    public Equipe removeMembre(@PathVariable Long id, @PathVariable Long membreId) {
        return equipeService.removeMembre(id, membreId);
    }

    // modifier le représentant d'une équipe
    @PutMapping("/{id}/representant/{representantId}")
    public Equipe updateRepresentant(@PathVariable Long id, @PathVariable Long representantId) {
        return equipeService.updateRepresentant(id, representantId);
    }

    // Récupérer les équipes d'un membre
    @GetMapping("/membres/{membreId}")
    public List<Equipe> findByMembre(@PathVariable Long membreId) {
        return equipeService.findByMembre(membreId);
    }
}
