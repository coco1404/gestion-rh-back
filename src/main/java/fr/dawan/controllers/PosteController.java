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
    
    @GetMapping(value = "/{idTypeContrat}", produces = "application/json")
    public List<PosteDto> getAllPosteByTypeContrat(@PathVariable("idTypeContrat") long idTypeContrat) {
        return posteService.getPosteByTypeContrat(idTypeContrat);
    }
    
    @GetMapping(value = "/{idManager}", produces = "application/json")
    public List<PosteDto> getPosteByManager(@PathVariable("idManager") long idManager) {
        return posteService.getPosteByManager(idManager);
    }
    
    @GetMapping(value = "/{idLieuTravail}", produces = "application/json")
    public List<PosteDto> getPosteByLieuTravail(@PathVariable("idLieuTravail") long idLieuTravail) {
        return posteService.getPosteByLieuTravail(idLieuTravail);
    }
    
    @PostMapping(value = "/recherche",consumes = "application/json", produces = "application/json")
    public List<PosteDto> recherche(@RequestParam(value = "recherche", required = true) String recherche) {
        return posteService.recherchePoste(recherche);
    }
    
    @PostMapping(value = "/rechercheDate",consumes = "application/json", produces = "application/json")
    public List<PosteDto> recherche(@RequestParam(value = "dateDebut", required = true) Date dateDebut, @RequestParam(value = "dateFin", required = true) Date dateFin) {
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
