package ris.ekipa5.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ris.ekipa5.demo.repositories.UporabnikRepository;
import ris.ekipa5.demo.model.Uporabnik;

@Controller
@RequestMapping("/uporabnik")
public class UporabnikController {


    @Autowired
    private UporabnikRepository uporabnikDao;


    @GetMapping(name = "all")
    public Iterable<Uporabnik> getAll() {
        return uporabnikDao.findAll();
    }




}