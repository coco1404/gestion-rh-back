package fr.dawan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.TitrePosteDto;
import fr.dawan.services.TitrePosteService;

@RestController
@RequestMapping("/api/titrepostes")
public class TitrePosteController {

    @Autowired
    private TitrePosteService titrePosteService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllTitrePoste() throws Exception {
        List<TitrePosteDto> titrePoste = titrePosteService.findAll();
        if (titrePoste != null)
            return ResponseEntity.ok(titrePoste);
        else
            throw new Exception("Aucun titre de poste");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllTitrePosteByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<TitrePosteDto> titrePoste = titrePosteService.getAllTitresPostes(page, size);
        if (titrePoste != null)
            return ResponseEntity.ok(titrePoste);
        else
            throw new Exception("Aucun titre de poste pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getTitrePosteById(@PathVariable("id") long id) throws Exception {
        TitrePosteDto titrePoste = titrePosteService.findById(id);// status = ok, body (objet retourné)
        if (titrePoste != null)
            return ResponseEntity.ok(titrePoste);
        else
            throw new Exception("Aucun titre de poste pour l'id : " + id);
    }

    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getTitrePosteByName(@RequestParam("name") String name) throws Exception {
        List<TitrePosteDto> titrePoste = titrePosteService.findByName(name);
        if (titrePoste != null)
            return ResponseEntity.ok(titrePoste);
        else
            throw new Exception("Aucun titre de poste pour la recherche : " + name);
    }
    
    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countTitrePoste() throws Exception {
        long countTitrePoste = titrePosteService.countTitrePoste();
        if (countTitrePoste > 0)
            return ResponseEntity.ok(countTitrePoste);
        else
            throw new Exception("Aucun titre de poste");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public TitrePosteDto saveTitrePoste(@RequestBody TitrePosteDto tpDto) {
        return titrePosteService.saveOrUpdate(tpDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public TitrePosteDto updateTitrePoste(@RequestBody TitrePosteDto tpDto) {
        return titrePosteService.saveOrUpdate(tpDto);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteTitrePosteById(@PathVariable(value = "id") long id) {
        try {
            titrePosteService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
