package ris.ekipa5.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ris.ekipa5.demo.model.Projekt;
@Repository
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public interface ProjektRepository extends CrudRepository<Projekt, Long> {

}
