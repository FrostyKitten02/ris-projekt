package ris.ekipa5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Privilegij  {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name="naziv")
    private String naziv;

    @ManyToMany(mappedBy = "privilegiji")
    @JsonIgnore
    private Collection<Vloga> vloge;

}
