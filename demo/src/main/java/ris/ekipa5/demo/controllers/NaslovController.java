package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ris.ekipa5.demo.model.Naslov;
import ris.ekipa5.demo.repositories.NaslovRepositroy;

import java.util.Optional;


@RestController
@RequestMapping("/naslov")
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