package ris.ekipa5.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ris.ekipa5.demo.model.Projekt;

public interface ProjektRepository extends CrudRepository<Projekt, Long> {

}
