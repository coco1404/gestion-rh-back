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

import fr.dawan.dto.DomaineDto;
import fr.dawan.services.DomaineService;

@RestController
@RequestMapping("/api/domaines")
public class DomaineController {
    @Autowired
    private DomaineService domaineService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllDomaine() throws Exception {
        List<DomaineDto> domaine = domaineService.findAll();
        if (domaine != null)
            return ResponseEntity.ok(domaine);
        else
            throw new Exception("Aucun domaine");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllDomaineByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<DomaineDto> domaine = domaineService.getAllDomaines(page, size);
        if (domaine != null)
            return ResponseEntity.ok(domaine);
        else
            throw new Exception("Aucun domaine pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getDomaineById(@PathVariable("id") long id) throws Exception {
        DomaineDto domaine = domaineService.getById(id);// status = ok, body (objet retourné)
        if (domaine != null)
            return ResponseEntity.ok(domaine);
        else
            throw new Exception("Aucun domaine pour l'id : " + id);
    }

    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getDomaineByName(@RequestParam("name") String name) throws Exception {
        List<DomaineDto> domaine = domaineService.findByName(name);
        if (domaine != null)
            return ResponseEntity.ok(domaine);
        else
            throw new Exception("Aucun domaine pour le nom : " + name);
    }
    
    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countDomaine() throws Exception {
        long countDomaine = domaineService.countDomaine();
        if (countDomaine > 0)
            return ResponseEntity.ok(countDomaine);
        else
            throw new Exception("Aucun domaine");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public DomaineDto saveDomaine(@RequestBody DomaineDto dDto) {
        return domaineService.saveOrUpdate(dDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public DomaineDto updateDomaine(@RequestBody DomaineDto dDto) {
        return domaineService.saveOrUpdate(dDto);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
        try {
            domaineService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
