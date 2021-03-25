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
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.services.CompetenceService;

@RestController
@RequestMapping("/api/competences")
public class CompetenceController {
    
    @Autowired
    CompetenceService competenceService;
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllCompetence() throws Exception {
        List<CompetenceDto> competence = competenceService.getAllComptence();
        if(competence != null)
            return ResponseEntity.ok(competence);
        else
            throw new Exception("Aucunes compétences");
    }
    
    @GetMapping(value="/count", produces = "application/json")
    public ResponseEntity<?> countCompetence() throws Exception {
        long countCompetence = competenceService.countCompetence();
        if(countCompetence > 0)
            return ResponseEntity.ok(countCompetence);
        else
            throw new Exception("Aucunes compétences");
    }
    
    //CompetenceDto saveOrUpdate(CompetenceDto competenceDto); 
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CompetenceDto saveCompetence(@RequestBody CompetenceDto cDto) {
        return competenceService.saveOrUpdate(cDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public CompetenceDto updateCompetence(@RequestBody CompetenceDto cDto) {
        return competenceService.saveOrUpdate(cDto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id", required = true) long id) {
        try {
            competenceService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }
}
