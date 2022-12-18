package ris.ekipa5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ris.ekipa5.demo.model.Privilegij;
@Repository
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public interface PrivilegijRepository extends CrudRepository<Privilegij, Long> {
    Privilegij findByNaziv(String naziv);
}
