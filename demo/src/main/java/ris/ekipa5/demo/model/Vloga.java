package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class Vloga {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="naziv")
    private String naziv;
    @ManyToMany(mappedBy = "vloge")
    @JsonIgnore
    private Collection<Uporabnik> uporabniki;

    @ManyToMany
    @JoinTable(
            name = "vloga_privilegiji",
            joinColumns = @JoinColumn(
                    name = "vloga_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilegij_id", referencedColumnName = "id"))
    private Collection<Privilegij> privilegiji;


}
