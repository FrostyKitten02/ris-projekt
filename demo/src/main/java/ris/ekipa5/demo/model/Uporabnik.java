package ris.ekipa5.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class Uporabnik implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="uporabniskoIme", unique = true)
    private String uporabniskoIme;

    @Column(name="ime")
    private String ime;

    @Column(name="priimek")
    private String priimek;

    @Column(name="datum_rojstva")
    private LocalDate datumRojstva;

    @Column(name="zaposleni_od")
    private LocalDate datumZaposlitve;

    @Column(name="drzavljanstvo")
    private String drzavljanstvo;

    @Column(name="je_zaposlen", nullable = false)
    private boolean jeZaposlen;
    @Column(name="aktiven", nullable = false)
    private boolean aktiven;
    @Column(name="geslo", nullable = false)
    private String geslo;

    @Column(name="email", nullable = false)
    private String email;

    //TODO ni vredu povezano!
    @ManyToMany
    @JoinTable(
            name = "uporabnik_vloge",
            joinColumns = @JoinColumn(
                    name = "uporabnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "vloga_id", referencedColumnName = "id"))
    private Collection<Vloga>  vloge;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView
    private Naslov naslov;

    @ManyToMany(mappedBy = "uporabnikiNaProjektu")
    @JsonIgnore
    private List<Projekt> projekti;








    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;//TODO!!!
    }

    @Override
    public String getPassword() {
        return this.geslo;
    }

    @Override
    public String getUsername() {
        return this.uporabniskoIme;//TODO maybe return email?
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.aktiven;
    }
}
