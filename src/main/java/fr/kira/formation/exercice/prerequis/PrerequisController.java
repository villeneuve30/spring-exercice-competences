package fr.kira.formation.exercice.prerequis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prerequis")
public class PrerequisController {

    @Autowired
    PrerequisService prerequisService;

    @GetMapping
    public List<Prerequis> findAll() {
        return prerequisService.findAll();
    }

    @PostMapping
    public Prerequis save(@RequestBody Prerequis prerequis) {
        return prerequisService.save(prerequis);
    }

    @GetMapping("/{id}")
    public Prerequis findById(Long aLong) {
        return prerequisService.findById(aLong);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long aLong) {
        prerequisService.deleteById(aLong);
    }
}
