package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Projekt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "datum_zacetka")
    private String datum_zacetka;

    @Column(name = "datum_konca")
    private String datum_konca;

    @ManyToMany
    @JoinTable(
            name = "uporabniki_projekt",
            joinColumns = {@JoinColumn(name = "projekt_id")},
            inverseJoinColumns = {@JoinColumn(name = "uporabnik_id")})
    @JsonView
    private List<Uporabnik> uporabnikiNaProjektu;

    @ManyToOne(fetch = FetchType.LAZY)
    private Uporabnik odgovorni_na_projektu;

}
