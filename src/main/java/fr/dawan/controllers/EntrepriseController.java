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

import fr.dawan.dto.EntrepriseDto;
import fr.dawan.services.EntrepriseService;

@RestController
@RequestMapping("/api/entreprises")
public class EntrepriseController {
    @Autowired
    private EntrepriseService entrepriseService;
    
    
    @GetMapping(produces = "application/json")
    public @ResponseBody List<EntrepriseDto> getAllEntreprises() {
        return entrepriseService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<EntrepriseDto> getAllEntreprisesPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return entrepriseService.getAllEntreprises(page, size);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public EntrepriseDto getEntrepriseById(@PathVariable("id") long id) {
        return entrepriseService.findById(id);// status = ok, body (objet retourné)
    }
    
    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public EntrepriseDto getEntrepriseByName(@RequestParam("name") String name) {
        return entrepriseService.findByName(name);
    }
    @GetMapping(value = "/adresse/{id}", produces = { "application/json", "application/xml" })
    public EntrepriseDto getEntrepriseByAdresse(@PathVariable("id") long id) {
        return entrepriseService.findByAdresseId(id);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public EntrepriseDto saveEntreprise(@RequestBody EntrepriseDto eDto) {
        return entrepriseService.saveOrUpdate(eDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public EntrepriseDto updateEntreprise(@RequestBody EntrepriseDto eDto) {
        return entrepriseService.saveOrUpdate(eDto);
    }

    
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteEntrepriseById(@PathVariable(value = "id") long id) {
        try {
            entrepriseService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
    
}
