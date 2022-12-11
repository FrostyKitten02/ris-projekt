package ris.ekipa5.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Uporabnik {

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

    @Column(name="je_zaposlen")
    private boolean jeZaposlen;

    @Column(name="aktiven")
    private boolean aktiven;

    @Column(name="geslo")
    private String geslo;

    @Column(name="email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "uporabnik_vloge",
            joinColumns = @JoinColumn(
                    name = "uporabnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "vloga_id", referencedColumnName = "id"))
    private Collection<Vloga>  vloge;
}
