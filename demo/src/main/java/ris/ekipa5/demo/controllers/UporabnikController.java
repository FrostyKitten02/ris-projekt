package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ris.ekipa5.demo.model.Uporabnik;
import ris.ekipa5.demo.repositories.UporabnikRepository;

import java.util.Optional;


@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {


    @Autowired
    private UporabnikRepository uporabnikDao;


    @GetMapping
    public Iterable<Uporabnik> getAll() {
        return uporabnikDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Uporabnik> getById(@PathVariable Long id){
        return uporabnikDao.findById(id);
    }

    @PostMapping
    public Uporabnik addUporabnik(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }
}