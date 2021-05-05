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

import fr.dawan.dto.CompetenceDto;
import fr.dawan.dto.PosteDto;
import fr.dawan.services.CompetenceService;
import fr.dawan.services.PosteService;

@RestController
@RequestMapping("/api/postes")
public class PosteController {

    @Autowired
    PosteService posteService;

    @Autowired
    CompetenceService competenceService;

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public ResponseEntity<?> getAllPosteByPage(@PathVariable("page") int page, @PathVariable("size") int size)
            throws Exception {
        List<PosteDto> poste = posteService.getAllPosteByPage(page, size);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste pour la taille : " + size + " et la page : " + page);
    }
    
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllPoste()
            throws Exception {
        List<PosteDto> poste = posteService.getAllPoste();
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste");
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getPosteById(@PathVariable("id") int id)
            throws Exception {
        PosteDto poste = posteService.getPosteById(id);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste pour l'id : "+id);
    }
    
    @GetMapping(value = "/typecontrat/{idTypeContrat}", produces = "application/json")
    public ResponseEntity<?> getAllPosteByTypeContrat(@PathVariable("idTypeContrat") long idTypeContrat)
            throws Exception {
        List<PosteDto> poste = posteService.getPosteByTypeContrat(idTypeContrat);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste pour l'id type de contrat : " + idTypeContrat);
    }

    @GetMapping(value = "/manager/{idManager}", produces = "application/json")
    public ResponseEntity<?> getPosteByManager(@PathVariable("idManager") long idManager) throws Exception {
        List<PosteDto> poste = posteService.getPosteByManager(idManager);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste pour l'id manager : " + idManager);
    }

    @GetMapping(value = "/adresse/{idLieuTravail}", produces = "application/json")
    public ResponseEntity<?> getPosteByLieuTravail(@PathVariable("idLieuTravail") long idLieuTravail) throws Exception {
        List<PosteDto> poste = posteService.getPosteByLieuTravail(idLieuTravail);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste l'id adresse (lieu de travail) : " + idLieuTravail);
    }

    @GetMapping(value = "/recherche", produces = "application/json")
    public ResponseEntity<?> recherche(@RequestParam(value = "initilue", required = true) String initilue)
            throws Exception {
        List<PosteDto> poste = posteService.recherchePoste(initilue);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste la recherche : " + initilue);
    }

    @GetMapping(value = "/rechercheDate", produces = "application/json")
    public ResponseEntity<?> rechercheDate(
            @RequestParam(value = "dateDebut", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(value = "dateFin", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin)
            throws Exception {
        List<PosteDto> poste = posteService.recherchePoste(dateDebut, dateFin);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucun poste dans la période : " + dateDebut + " et " + dateFin);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public PosteDto savePoste(@RequestBody PosteDto pDto) {
        return posteService.saveOrUpdate(pDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public PosteDto updatePoste(@RequestBody PosteDto pDto) {
        return posteService.saveOrUpdate(pDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteByIdPoste(@PathVariable(value = "id", required = true) long id) {
        try {
            posteService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }

    @GetMapping(value = "/{idPoste}/competences", produces = "application/json")
    public ResponseEntity<?> getCompetenceByIdPoste(@PathVariable("idPoste") long idPoste) throws Exception {
        List<CompetenceDto> poste = competenceService.getComptenceByIdPoste(idPoste);
        if (poste != null)
            return ResponseEntity.ok(poste);
        else
            throw new Exception("Aucune compétence pour l'id poste : " + idPoste);
    }
    
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> countPoste() throws Exception {
        long countPoste = competenceService.countCompetence();
        if (countPoste > 0)
            return ResponseEntity.ok(countPoste);
        else
            throw new Exception("Aucun poste");
    }
}
