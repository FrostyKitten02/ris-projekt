package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ris.ekipa5.demo.model.Naslov;
import ris.ekipa5.demo.repositories.NaslovRepositroy;

import java.util.Optional;


@RestController
@RequestMapping("/naslov")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class NaslovController {

    @Autowired
    private NaslovRepositroy naslovDao;


    @GetMapping("/all")
    public Iterable<Naslov> getAll() {
        return naslovDao.findAll();
    }

    @PostMapping
    public Naslov addNaslov(@RequestBody Naslov naslov) {
        return naslovDao.save(naslov);
    }

    @DeleteMapping("/{id}")
    public Naslov deleteNaslo(@PathVariable long id) {
        Optional<Naslov> naslov = naslovDao.findById(id);
        if (naslov.isEmpty()) {
            return null;
        }
        naslovDao.delete(naslov.get());
        return naslov.get();
    }

}