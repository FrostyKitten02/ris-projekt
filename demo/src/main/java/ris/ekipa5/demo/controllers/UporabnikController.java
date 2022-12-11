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
import ris.ekipa5.demo.model.Projekt;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.model.UporabnikiProjekt;
import ris.ekipa5.demo.repositories.ProjektRepository;
import ris.ekipa5.demo.repositories.UporabnikRepository;
import ris.ekipa5.demo.repositories.UporabnikiProjektRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {


    @Autowired
    private UporabnikRepository uporabnikDao;

    @Autowired
    private ProjektRepository projektDao;

    @Autowired
    private UporabnikiProjektRepository uporabnikiProjektDao;


    @GetMapping("/login")
    public boolean login(){

        return false;
    }

    @GetMapping
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

    @GetMapping("{idUporabnik}/dodaj/na-projekt/{idProjekt}")
    public void dodajUporabnikaNaProjekt(@PathVariable long idUporabnik, @PathVariable long idProjekt) {

        Optional<Projekt> projekt = projektDao.findById(idProjekt);
        Optional<Uporabnik> uporabnik = uporabnikDao.findById(idUporabnik);

        if (uporabnik.isEmpty() || projekt.isEmpty()) {
            //TODO throw error!
            return;
        }
        UporabnikiProjekt uporabnikiProjekt = new UporabnikiProjekt();
        uporabnikiProjekt.setUporabnik(uporabnik.get());
        uporabnikiProjekt.setProjekt(projekt.get());
        uporabnikiProjektDao.save(uporabnikiProjekt);
    }

    @GetMapping("/na-min-projektih/{amount}")
    public List<Uporabnik> uporabnikNaMinPorojektih(@PathVariable int amount) {
        Iterable<Uporabnik> vsiUporabniki = uporabnikDao.findAll();
        List<Uporabnik> res = new ArrayList<>();

        vsiUporabniki.forEach(uporabnik -> {
            if (uporabnik.getProjekti().size() >= amount) {
                res.add(uporabnik);
            }
        });
        return res;
    }
}