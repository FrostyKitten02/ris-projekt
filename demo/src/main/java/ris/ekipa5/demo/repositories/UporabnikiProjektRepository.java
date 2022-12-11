package ris.ekipa5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ris.ekipa5.demo.model.UporabnikiProjekt;

@Repository
public interface UporabnikiProjektRepository extends CrudRepository<UporabnikiProjekt, Long> {
}
