package fr.kira.formation.exercice.auth;

import fr.kira.formation.exercice.auth.dto.RegisterRequestDto;
import fr.kira.formation.exercice.auth.roles.Role;
import fr.kira.formation.exercice.personnes.Personne;
import fr.kira.formation.exercice.personnes.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Personne register(RegisterRequestDto dto){
        Personne utilisateur = new Personne();
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setRoles(List.of(new Role("USER")));
        String password = passwordEncoder.encode(dto.getPassword());
        utilisateur.setPassword(password);
        return this.personneRepository.save(utilisateur);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne utilisateur = personneRepository.findByUsername(username);
        if (utilisateur == null){
            throw new UsernameNotFoundException("Aucun utilisateur ne possède l'username "+username);
        }
        return new User(utilisateur.getUsername(), utilisateur.getPassword(), utilisateur.getRoles());
    }

}
