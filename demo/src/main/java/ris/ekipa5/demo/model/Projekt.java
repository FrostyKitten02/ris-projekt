package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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
    @JoinColumn(name="odgovorni_na_projektu_id", referencedColumnName = "id")
    @JsonView
    private Uporabnik odgovorni_na_projektu;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "projekt")
    @JsonView
    private List<DelovniNalog> delovniNalogi;

}
