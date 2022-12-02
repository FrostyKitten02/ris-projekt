package ris.ekipa5.demo.model;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Uporabnik {

    @Column(name="id")
    private Long id;

    @Column(name="ime")
    private String ime;

    @Column(name="datum_rojstva")
    private Date datumRojstva;

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
