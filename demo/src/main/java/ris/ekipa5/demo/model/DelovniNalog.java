package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "delovni_nalog")
public class DelovniNalog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name="opis")
    private String opis;
    @Column(name="zakljucen")
    private boolean zakljucen;
    @ManyToOne
    @JoinColumn(name="projekt_id", referencedColumnName = "id")
    @JsonIgnore
    private Projekt projekt;

}
