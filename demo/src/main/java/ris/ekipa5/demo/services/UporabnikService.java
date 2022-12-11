package ris.ekipa5.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ris.ekipa5.demo.model.Privilegij;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.model.Vloga;
import ris.ekipa5.demo.repositories.UporabnikRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service("userDetaislService")
@Transactional
public class UporabnikService implements UserDetailsService {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Uporabnik> uporabnik = uporabnikDao.findByUporabniskoIme(username);

        if (uporabnik.isEmpty()) {
            throw new UsernameNotFoundException("Ni uporabnika z uporabniskim imenom: " + username);
        }

        Uporabnik uporabnikEntity = uporabnik.get();

        return new org.springframework.security.core.userdetails.User(
                uporabnikEntity.getEmail(), uporabnikEntity.getGeslo(), uporabnikEntity.isAktiven(), true, true,
                true, getAuthorities(uporabnikEntity.getVloge()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Vloga> vloga) {

        return getGrantedAuthorities(getPrivileges(vloga));
    }

    private List<String> getPrivileges(Collection<Vloga> vloge) {

        List<String> naziviVlog = new ArrayList<>();
        List<Privilegij> privilegiji = new ArrayList<>();
        for (Vloga vloga : vloge) {
            naziviVlog.add(vloga.getNaziv());
            privilegiji.addAll(vloga.getPrivilegiji());
        }
        for (Privilegij privilegij : privilegiji) {
            naziviVlog.add(privilegij.getNaziv());
        }
        return naziviVlog;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

}
