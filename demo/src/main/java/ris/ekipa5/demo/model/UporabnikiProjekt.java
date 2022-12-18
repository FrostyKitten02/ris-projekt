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
@Table(name = "uporabniki_projekt")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UporabnikiProjekt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Uporabnik uporabnik;

    @OneToOne
    private Projekt projekt;

}
