package ris.ekipa5.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.Projekt;
@Repository
public interface ProjektRepository extends CrudRepository<Projekt, Long> {

}
