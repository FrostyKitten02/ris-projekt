package ris.ekipa5.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Uporabnik {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

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
}
