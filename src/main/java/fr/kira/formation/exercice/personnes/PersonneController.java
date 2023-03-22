package fr.kira.formation.exercice.personnes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping("/")
    public Personne save(@RequestBody Personne personne) {
        return personneService.save(personne);
    }

    @GetMapping("/{id}")
    public Personne findById(@PathVariable Long id) {
        return personneService.findById(id);
    }

    @GetMapping("/")
    public List<Personne> findAll() {
        return personneService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personneService.deleteById(id);
    }

    @GetMapping("/nom/{nom}")
    public List<Personne> findByNom(@PathVariable String nom) {
        return personneService.findByNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public List<Personne> findByPrenom(@PathVariable String prenom) {
        return personneService.findByPrenom(prenom);
    }
}
