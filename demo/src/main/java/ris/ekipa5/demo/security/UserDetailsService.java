package ris.ekipa5.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.repositories.UporabnikRepository;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UporabnikRepository uporabnikRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Uporabnik> uporabnik = uporabnikRepository.findByUporabniskoIme(username);
        return uporabnik.orElse(null);
    }
}
