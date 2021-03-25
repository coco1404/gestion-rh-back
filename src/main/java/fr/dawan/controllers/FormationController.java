package fr.dawan.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import fr.dawan.dto.CreateFormationDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.services.FormationService;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    @Autowired
    FormationService formationService;

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public ResponseEntity<?> getAllFormationByPage(@PathVariable("page") int page, @PathVariable("size") int size)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormation(page, size);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/encours/{page}/{size}", produces = "application/json")
    public ResponseEntity<?> getAllFormationEnCours(@PathVariable("page") int page, @PathVariable("size") int size)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormationEnCours(page, size);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation en cours pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/noncommence/{page}/{size}", produces = "application/json")
    public ResponseEntity<?> getAllFormationNonCommence(@PathVariable("page") int page, @PathVariable("size") int size)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormationNonCommence(page, size);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation non commencée pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/competence/{idCompetence}", produces = "application/json")
    public ResponseEntity<?> getAllFormationByIdCompetence(@PathVariable("idCompetence") int idCompetence)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormationByIdCompetence(idCompetence);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation avec l'id competence : " + idCompetence);
    }

    @GetMapping(value = "/date", produces = "application/json")
    public ResponseEntity<?> getAllFormationByDate(
            @RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormationByDate(date);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation à la date : " + date);
    }

    @GetMapping(value = "/periode", produces = "application/json")
    public ResponseEntity<?> getAllFormationByPeriode(
            @RequestParam(value = "dateDebut", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin)
            throws Exception {
        List<FormationDto> formation = formationService.getAllFormationByPeriode(dateDebut, dateFin);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation entre " + dateDebut + " et " + dateFin);
    }

    @GetMapping(value = "/{idFormation}/salaries", produces = "application/json")
    public ResponseEntity<?> getSalarieByIdFormation(@PathVariable("idFormation") int idFormation) throws Exception {
        List<SalarieDto> salarie = formationService.getSalarieByIdFormation(idFormation);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id formation " + idFormation);
    }
    
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> countFormation() throws Exception {
        long countSalarie = formationService.countFormation();
        if (countSalarie > 0)
            return ResponseEntity.ok(countSalarie);
        else
            throw new Exception("Aucun salarié");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CreateFormationDto saveFormation(@RequestBody CreateFormationDto fDto) {
        return formationService.saveOrUpdate(fDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public CreateFormationDto updateFormation(@RequestBody CreateFormationDto fDto) {
        return formationService.saveOrUpdate(fDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteByIdFormation(@PathVariable(value = "id", required = true) long id) {
        try {
            formationService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }
}
