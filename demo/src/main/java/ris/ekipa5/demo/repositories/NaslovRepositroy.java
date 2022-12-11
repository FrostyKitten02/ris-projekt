package ris.ekipa5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.Naslov;

import java.util.Collection;

@Repository
public interface NaslovRepositroy extends CrudRepository<Naslov, Long> {

}
