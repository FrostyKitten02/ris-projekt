package ris.ekipa5.demo.controllers;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ris.ekipa5.demo.model.Projekt;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.repositories.ProjektRepository;
import ris.ekipa5.demo.repositories.UporabnikRepository;
import ris.ekipa5.demo.request.ProjektSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projekt")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProjektController {
    @Autowired
    private ProjektRepository ProjektDao;

    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping
    public Iterable<Projekt> vrniProjekte() {
        return ProjektDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Projekt> vrniProjekte(@PathVariable(name = "id") Long id) {
        return ProjektDao.findById(id);
    }

    @PostMapping
    public Projekt dodajProjekt(@RequestBody Projekt projekt) {
        return ProjektDao.save(projekt);
    }

    @DeleteMapping("/{id}")
    public Optional<Projekt> dodajProjekt(@PathVariable(name = "id") Long id) {
        //Optional<Projekt> projekt = ProjektDao.findById(id);
        return ProjektDao.findById(id);
    }


    @GetMapping("/min-uporabnikov/{amount}")
    public List<Projekt> getProjektPoMinUporabnikih(@PathVariable int amount) {
        Iterable<Projekt> projekti = ProjektDao.findAll();
        List<Projekt> res = new ArrayList<>();
        projekti.forEach(projekt -> {
            if (projekt.getUporabnikiNaProjektu().size() >= amount) {
                res.add(projekt);
            }
        });
        return res;
    }

    @PostMapping("/search")
    public List<Projekt> getProjektPoMinUporabnikihInMinDelovnihNalogovInImaOdgovornega(@RequestBody ProjektSearch searchParams) {
        Iterable<Projekt> projekti;

        if (searchParams.getSearchString() != null) {
            projekti = ProjektDao.getProjektByNaziv(searchParams.getSearchString());
        } else {
            projekti = ProjektDao.findAll();
        }

        List<Projekt> res = new ArrayList<>();
        projekti.forEach(projekt -> {
            if (searchParams.getImaOdgovornega() != null) {
                if (searchParams.getImaOdgovornega() && projekt.getOdgovorni_na_projektu() == null) {
                    return;
                } else if(!searchParams.getImaOdgovornega() && projekt.getOdgovorni_na_projektu() != null){
                    return;
                }
            }

            if (searchParams.getMinZaposelenih() != null) {
                int uproabnikiNaProjektu = projekt.getUporabnikiNaProjektu().size();
                if (uproabnikiNaProjektu < searchParams.getMinZaposelenih()) {
                    return;
                }
            }

            if (searchParams.getMinDelovnihNalogov() != null) {
                int delovniNalogiNaProjektu = projekt.getDelovniNalogi().size();
                if (delovniNalogiNaProjektu < searchParams.getMinDelovnihNalogov()) {
                    return;
                }
            }

            res.add(projekt);
        });
        return res;
    }

    @PutMapping("/{projektId}/uporabnik/{uporabnikId}")
    public void addResponsibleEmployees(@PathVariable Long projektId, @PathVariable Long uporabnikId) {
        if (uporabnikId == null || uporabnikId == null) {
            return;
        }

        Projekt projekt = ProjektDao.findById(projektId).orElse(null);
        Uporabnik uporabnik = uporabnikDao.findById(uporabnikId).orElse(null);

        if (projekt == null || uporabnik == null) {
            return;
        }

        projekt.setOdgovorni_na_projektu(uporabnik);

        ProjektDao.save(projekt);

    }

}
