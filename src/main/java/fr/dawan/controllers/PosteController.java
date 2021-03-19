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
    public List<PosteDto> getAllPosteByPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        return posteService.getAllPoste(page, size);
    }
    
    @GetMapping(value = "/typecontrat/{idTypeContrat}", produces = "application/json")
    public List<PosteDto> getAllPosteByTypeContrat(@PathVariable("idTypeContrat") long idTypeContrat) {
        return posteService.getPosteByTypeContrat(idTypeContrat);
    }
    
    @GetMapping(value = "/manager/{idManager}", produces = "application/json")
    public List<PosteDto> getPosteByManager(@PathVariable("idManager") long idManager) {
        return posteService.getPosteByManager(idManager);
    }
    
    @GetMapping(value = "/adresse/{idLieuTravail}", produces = "application/json")
    public List<PosteDto> getPosteByLieuTravail(@PathVariable("idLieuTravail") long idLieuTravail) {
        return posteService.getPosteByLieuTravail(idLieuTravail);
    }
    
    @GetMapping(value = "/recherche", produces = "application/json")
    public List<PosteDto> recherche(@RequestParam(value = "initilue", required = true) String initilue) {
        return posteService.recherchePoste(initilue);
    }
    
    @GetMapping(value = "/rechercheDate", produces = "application/json")
    public List<PosteDto> rechercheDate(@RequestParam(value = "dateDebut", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDebut, @RequestParam(value = "dateFin", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateFin) {
        return posteService.recherchePoste(dateDebut, dateFin);
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
    public List<CompetenceDto> getCompetenceByIdPoste(@PathVariable("idPoste") long idPoste) {
        return competenceService.getComptenceByIdPoste(idPoste);
    }
}
