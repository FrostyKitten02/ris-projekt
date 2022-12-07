package ris.ekipa5.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.Collection;

@Getter
@Setter
@Entity
public class Projekt {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "datum_zacetka")
    private String datum_zacetka;

    @Column(name = "datum_konca")
    private String datum_konca;

    /*
    @ManyToMany
    @Column(name = "uporabniki_na_projektu")
    private Collection<Uporabnik> uporabniki_na_projektu;
    */

    @ManyToOne(fetch = FetchType.LAZY)
    private Uporabnik odgovorni_na_projektu;

}
