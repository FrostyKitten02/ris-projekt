package ris.ekipa5.demo.controllers;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/{id}")
    public Optional<Projekt> dodajProjekt(@RequestBody Projekt projekt, @PathVariable(name = "id") Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Optional<Projekt> dodajProjekt(@PathVariable(name = "id") Long id) {
        //Optional<Projekt> projekt = ProjektDao.findById(id);
        return ProjektDao.findById(id);
    }
}
