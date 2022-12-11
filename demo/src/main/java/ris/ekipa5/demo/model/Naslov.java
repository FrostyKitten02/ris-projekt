package ris.ekipa5.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Naslov {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "mesto", nullable = false)
    private String mesto;

    @Column(name = "hisna_stevilka", nullable = false)
    private String hisnaStevilka;

    @Column(name = "drzava", nullable = false)
    private String drzava;

    @Column(name = "postna_stevilka", nullable = false)
    private int postnaStevilka;


}
