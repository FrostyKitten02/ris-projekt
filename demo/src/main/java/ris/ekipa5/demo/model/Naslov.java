package ris.ekipa5.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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
