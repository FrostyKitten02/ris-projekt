package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ris.ekipa5.demo.model.Projekt;
import ris.ekipa5.demo.repositories.ProjektRepository;

import java.util.Optional;

@RestController
@RequestMapping("/projekt")
public class ProjektController {
    @Autowired
    private ProjektRepository ProjektDao;


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
    public Optional<Projekt> zbrisiProjekt(@PathVariable(name = "id") Long id) {
        Optional<Projekt> projekt = ProjektDao.findById(id);
        if (projekt.isPresent()) {
            ProjektDao.delete(projekt.get());
        }
        return projekt;
    }
}
