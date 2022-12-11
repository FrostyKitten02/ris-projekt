package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vloga {

    @Id
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
