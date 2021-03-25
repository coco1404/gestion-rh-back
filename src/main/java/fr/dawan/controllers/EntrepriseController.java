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
    public @ResponseBody ResponseEntity<?> getAllEntreprises() throws Exception {
        List<EntrepriseDto> entreprise = entrepriseService.findAll();
        if(entreprise != null)
            return ResponseEntity.ok(entreprise);
        else
            throw new Exception("Aucune entreprise");
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllEntreprisesPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<EntrepriseDto> entreprise = entrepriseService.getAllEntreprises(page, size);
        if(entreprise != null)
            return ResponseEntity.ok(entreprise);
        else
            throw new Exception("Aucune entreprise pour la taille : "+size+" et la page : "+page);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getEntrepriseById(@PathVariable("id") long id) throws Exception {
        EntrepriseDto entreprise =  entrepriseService.findById(id);// status = ok, body (objet retourné)
        if(entreprise != null)
            return ResponseEntity.ok(entreprise);
        else
            throw new Exception("Aucune entreprise pour l'id : "+id);
    }
    
    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getEntrepriseByName(@RequestParam("name") String name) throws Exception {
        List<EntrepriseDto> entreprise = entrepriseService.findByName(name);
        if(entreprise != null)
            return ResponseEntity.ok(entreprise);
        else
            throw new Exception("Aucune entreprise pour le nom : "+name);
    }
    
    @GetMapping(value = "/adresse/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getEntrepriseByAdresse(@PathVariable("id") long id) throws Exception {
        EntrepriseDto entreprise = entrepriseService.findByAdresseId(id);
        if(entreprise != null)
            return ResponseEntity.ok(entreprise);
        else
            throw new Exception("Aucune entreprise l'id adresse : "+id);
    }
    
    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countEntreprise() throws Exception {
        long countEntreprise = entrepriseService.countEntreprise();
        if(countEntreprise > 0)
            return ResponseEntity.ok(countEntreprise);
        else
            throw new Exception("Aucune entreprise");
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
