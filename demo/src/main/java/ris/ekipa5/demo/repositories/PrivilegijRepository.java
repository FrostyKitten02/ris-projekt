package ris.ekipa5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.Privilegij;
@Repository
public interface PrivilegijRepository extends CrudRepository<Privilegij, Long> {
    Privilegij findByNaziv(String naziv);
}
