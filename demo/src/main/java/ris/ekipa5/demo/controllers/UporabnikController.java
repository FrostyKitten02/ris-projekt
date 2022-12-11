package ris.ekipa5.demo.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.repositories.UporabnikRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {


    @Autowired
    private UporabnikRepository uporabnikDao;


    @GetMapping("/login")
    public boolean login(){

        return false;
    }

    //NEVEM!!!
    @GetMapping
    @Secured("ROLE_ADMIN")
    public Iterable<Uporabnik> getAll() {
        return uporabnikDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable Long id){
        return uporabnikDao.findById(id);
    }

    @PostMapping
    public Uporabnik addUporabnik(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }

    @PutMapping
    public Uporabnik changeUporabnik(@RequestBody Uporabnik uporabnik){//dto???
        return uporabnikDao.save(uporabnik);
    }

    @DeleteMapping("/{id}")
    public Uporabnik deleteUporabnik(@PathVariable Long id) {
        Optional<Uporabnik> uporabnik = uporabnikDao.findById(id);
        if (uporabnik.isPresent()) {
            uporabnikDao.delete(uporabnik.get());
            return uporabnik.get();
        }
        return null;
    }

    @GetMapping("/aktiven-zaposleni")
    public Collection<Uporabnik> jeZaposleniInJeAktiven(@RequestParam boolean aktiven, @RequestParam boolean zaposleni) {
        return uporabnikDao.uporabnikAktivenZaposlen(aktiven,zaposleni);
    }

    @GetMapping("/search")
    public Collection<Uporabnik> zaposleniRojenDelaOdJeAktiven(@RequestParam boolean aktiven, @RequestParam LocalDate rojenPo, @RequestParam LocalDate delaOd) {
        return uporabnikDao.search(aktiven, rojenPo, delaOd);
    }

    @GetMapping("/search2")
    public Collection<Uporabnik> zaposelniImePriimekInJeAktiven(@RequestParam boolean aktiven, @RequestParam String ime, @RequestParam String priimek){
        return uporabnikDao.search2(aktiven, ime, priimek);
    }

}