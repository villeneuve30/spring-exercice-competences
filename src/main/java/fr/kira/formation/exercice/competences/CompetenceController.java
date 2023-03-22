package fr.kira.formation.exercice.competences;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping("/")
    public Competence save(@RequestBody Competence entity) {
        return competenceService.save(entity);
    }

    @GetMapping("/{id}")
    public Competence findById(@PathVariable Long id) {
        return competenceService.findById(id);
    }

    @GetMapping("/")
    public List<Competence> findAll() {
        return competenceService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        competenceService.deleteById(id);
    }
}
