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

import fr.dawan.dto.AdresseDto;
import fr.dawan.services.AdresseService;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    ///api/adresses?filtre=ville&sort=ASC
    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllAdresse(@RequestParam(name = "filtre",required = false) String filtre, @RequestParam(name = "sort",required = false) String sort) throws Exception {
        List<AdresseDto> adresse = adresseService.findAll(filtre, sort);
        if (adresse != null)
            return ResponseEntity.ok(adresse);
        else
            throw new Exception("Aucunes adresses");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllAdresseByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<AdresseDto> adresse = adresseService.getAllAdresses(page, size);
        if (adresse != null)
            return ResponseEntity.ok(adresse);
        else
            throw new Exception("Aucune adresse pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getAdresseById(@PathVariable("id") long id) throws Exception {
        AdresseDto adresse = adresseService.getById(id);// status = ok, body (objet retourné)
        if (adresse != null)
            return ResponseEntity.ok(adresse);
        else
            throw new Exception("Aucune adresse pour l'id : " + id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public AdresseDto saveAdresse(@RequestBody AdresseDto aDto) {
        return adresseService.saveOrUpdate(aDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public AdresseDto updateAdresse(@RequestBody AdresseDto aDto) {
        return adresseService.saveOrUpdate(aDto);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
        try {
            adresseService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
