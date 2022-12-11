package ris.ekipa5.demo.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.Vloga;
@Repository
public interface VlogaRepository extends CrudRepository<Vloga, Long> {
    Vloga findByNaziv(String naziv);
}
