package ris.ekipa5.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ris.ekipa5.demo.model.Uporabnik;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public interface UporabnikRepository extends CrudRepository<Uporabnik,Long> {
    @Query("SELECT u FROM Uporabnik as u WHERE u.jeZaposlen = :zaposlen AND u.aktiven = :aktiven")
    Collection<Uporabnik> uporabnikAktivenZaposlen(@Param("aktiven") boolean aktiven, @Param("zaposlen") boolean zaposlen);
    @Query("SELECT u FROM Uporabnik as u WHERE u.aktiven = :aktiven AND u.datumRojstva > :rojenPo AND u.datumZaposlitve > :zaposleniOd")
    Collection<Uporabnik> search(@Param("aktiven") boolean aktiven, @Param("rojenPo") LocalDate rojenPo, @Param("zaposleniOd") LocalDate zaposlenOd);
    @Query("SELECT u FROM Uporabnik as u WHERE u.aktiven = :aktiven AND u.ime = :ime AND u.priimek = :priimek")
    Collection<Uporabnik> search2(@Param("aktiven") boolean aktiven, @Param("ime") String ime, @Param("priimek") String priimek);
    Optional<Uporabnik> findByUporabniskoIme(String uporabniskoIme);
    Uporabnik findByEmail(String email);
}