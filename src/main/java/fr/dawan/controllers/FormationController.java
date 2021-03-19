package fr.dawan.controllers;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.FormationDto;
import fr.dawan.services.FormationService;

@RestController
@RequestMapping("/api/formations")
public class FormationController {
    
    @Autowired
    FormationService formationService;
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public List<FormationDto> getAllPosteByPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        return formationService.getAllFormation(page, size);
    }
    
    @GetMapping(value = "/encours/{page}/{size}", produces = "application/json")
    public List<FormationDto> getAllFormationEnCours(@PathVariable("page") int page, @PathVariable("size") int size) {
        return formationService.getAllFormationEnCours(page, size);
    }

    @GetMapping(value = "/noncommence/{page}/{size}", produces = "application/json")
    public List<FormationDto> getAllFormationNonCommence(@PathVariable("page") int page, @PathVariable("size") int size) {
        return formationService.getAllFormationNonCommence(page, size);
    }
    
    @GetMapping(value = "/competence/{idCompetence}", produces = "application/json")
    public List<FormationDto> getAllFormationByIdCompetence(@PathVariable("idCompetence") int idCompetence) {
        return formationService.getAllFormationByIdCompetence(idCompetence);
    }
    
    @GetMapping(value = "/date", produces = "application/json")
    public List<FormationDto> getAllFormationByDate(@RequestParam(value = "date", required = true) Date date) {
        return formationService.getAllFormationByDate(date);
    }
    
    @GetMapping(value = "/periode", produces = "application/json")
    public List<FormationDto> getAllFormationByPeriode(@RequestParam(value = "dateDebut", required = true) Date dateDebut, @RequestParam(value = "dateFin", required = true) Date dateFin) {
        return formationService.getAllFormationByPeriode(dateDebut, dateFin);
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public FormationDto savePoste(@RequestBody FormationDto fDto) {
        return formationService.saveOrUpdate(fDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public FormationDto updatePoste(@RequestBody FormationDto fDto) {
        return formationService.saveOrUpdate(fDto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteByIdPoste(@PathVariable(value = "id", required = true) long id) {
        try {
            formationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }
}
