package ris.ekipa5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.Uporabnik;

@Repository
public interface UporabnikRepository extends CrudRepository<Uporabnik,Long> {
}
