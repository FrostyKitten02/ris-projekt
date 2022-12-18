package ris.ekipa5.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ris.ekipa5.demo.model.DelovniNalog;
import ris.ekipa5.demo.model.Projekt;
import ris.ekipa5.demo.repositories.DelovniNalogRepository;
import ris.ekipa5.demo.repositories.ProjektRepository;

@RestController
@RequestMapping("/delovni-nalog")
public class DelovniNalogController {

     @Autowired
     private DelovniNalogRepository delovniNalogDao;

     @Autowired
     private ProjektRepository projektDao;



    @GetMapping
    public Iterable<DelovniNalog> getAll() {
        return delovniNalogDao.findAll();
    }

    @GetMapping("/{id}")
    public DelovniNalog getById(@PathVariable Long id) {
        return delovniNalogDao.findById(id).orElse(null);
    }

    @PostMapping
    public DelovniNalog addNew(@RequestBody DelovniNalog novi){
        return delovniNalogDao.save(novi);
    }

    @PostMapping("/{nalogId}/projekt/{projektId}")
    public void addNalogToProjekt(@PathVariable Long nalogId, @PathVariable Long projektId) {
        if (projektId == null || nalogId == null) {
            return;
        }

        Projekt projekt = projektDao.findById(projektId).orElse(null);
        DelovniNalog delovniNalog = delovniNalogDao.findById(nalogId).orElse(null);

        if (projekt == null || delovniNalog == null) {
            return;
        }

        delovniNalog.setProjekt(projekt);

        delovniNalogDao.save(delovniNalog);
    }


}
