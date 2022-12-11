package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ris.ekipa5.demo.model.Naslov;
import ris.ekipa5.demo.repositories.NaslovRepositroy;


@RestController
@RequestMapping("/naslov")
public class NaslovController {

    @Autowired
    private NaslovRepositroy naslovDao;


    @GetMapping("/all")
    public Iterable<Naslov> getAll() {
        return naslovDao.findAll();
    }


}