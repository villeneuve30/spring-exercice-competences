package fr.kira.formation.exercice.auth.roles;

import fr.kira.formation.exercice.auth.AuthService;
import fr.kira.formation.exercice.auth.dto.RegisterRequestDto;
import fr.kira.formation.exercice.personnes.Personne;
import fr.kira.formation.exercice.personnes.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfiguration {

    public static Role MANAGER = null;
    public static Role USER = null;

    @Autowired
    private void init(RoleRepository repository, AuthService authService, PersonneRepository personneRepository){
        MANAGER = repository.save(new Role("MANAGER"));
        USER = repository.save(new Role("USER"));
        authService.register(new RegisterRequestDto("user","azerty"));
        Personne admin = authService.register(new RegisterRequestDto("manager", "manager"));
        admin.setRoles(List.of(new Role("MANAGER")));
        personneRepository.save(admin);
    }
}
