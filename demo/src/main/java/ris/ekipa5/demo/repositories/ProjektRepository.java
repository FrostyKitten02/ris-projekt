package ris.ekipa5.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ris.ekipa5.demo.model.Projekt;

import java.util.List;

public interface ProjektRepository extends CrudRepository<Projekt, Long> {
@Query("select o from Uporabnik o, Projekt p where p.odgovorni_na_projektu = p")
    List<Projekt> vrniProjekte(Projekt p);
}
