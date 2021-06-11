package fr.dawan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.dto.SalarieListeDto;
import fr.dawan.services.SalarieService;

@RestController
@RequestMapping("/api/salaries")
public class SalarieController {

    @Autowired
    private SalarieService salarieService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalaries() throws Exception {
        List<SalarieDto> salarie = salarieService.findAll();
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalariesByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<SalarieDto> salarie = salarieService.getAllSalaries(page, size);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour la taille : " + size + " et la page : " + page);
    }
    
    @GetMapping(value = "/{page}/{size}/{search}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getAllByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size, @PathVariable(value = "search", required = false) Optional<String> search) {
        if(search.isPresent())
            return salarieService.getAllSalarieByNom(page, size, search.get());
        else
            return salarieService.getAllSalarieByNom(page, size, "");
    }
    
    @GetMapping(value = "/sans-poste", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalariesWithoutPoste() throws Exception {
        List<SalarieDto> salarie = salarieService.getAllSalariesWithoutPoste();
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié sans poste ");
    }

    @GetMapping(value = "/adresse/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getSalariesByAdresse(@PathVariable("id") long id) throws Exception {
        List<SalarieDto> salarie = salarieService.findAllSalariesByAdresse(id);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id adresse : " + id);
    }

    @GetMapping(value = "/domaine/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getSalariesByDomaine(@PathVariable("id") long id) throws Exception {
        List<SalarieDto> salarie = salarieService.findAllSalariesByDomaine(id);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id domaine : " + id);
    }

    @GetMapping(value = "/entreprise/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getSalariesByEntreprise(@PathVariable("id") long id) throws Exception {
        List<SalarieDto> salarie = salarieService.findAllSalariesByEntreprise(id);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id entreprise : " + id);
    }

    @GetMapping(value = "/poste/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getSalariesByPoste(@PathVariable("id") long id) throws Exception {
        List<SalarieDto> salarie = salarieService.findAllSalariesByTitrePoste(id);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id titre de poste : " + id);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getSalarieById(@PathVariable("id") long id) throws Exception {
        SalarieDto salarie = salarieService.findById(id);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié pour l'id : " + id);
    }

    @GetMapping(value = "/{id}/formations", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getFormationBySalarie(@PathVariable("id") long id) throws Exception {
        List<FormationDto> formation = salarieService.findFormationBySalarie(id);
        if (formation != null)
            return ResponseEntity.ok(formation);
        else
            throw new Exception("Aucune formation pour l'id salarié : " + id);
    }

    @GetMapping(value = "/{id}/roles", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getRoleBySalarie(@PathVariable("id") long id) throws Exception {
        List<RoleDto> role = salarieService.findRoleBySalarie(id);
        if (role != null)
            return ResponseEntity.ok(role);
        else
            throw new Exception("Aucun role pour l'id salarié : " + id);
    }

    @GetMapping(value = "/{id}/competences", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getCompetenceBySalarie(@PathVariable("id") long id) throws Exception {
        List<CompetenceDto> competence = salarieService.findCompetenceBySalarie(id);
        if (competence != null)
            return ResponseEntity.ok(competence);
        else
            throw new Exception("Aucune compétence pour l'id salarié : " + id);
    }
    
    @GetMapping(value = "/count", produces = "application/json")
    public @ResponseBody ResponseEntity<?> countCompetence() throws Exception {
        long countSalarie = salarieService.countSalarie();
        if (countSalarie > 0)
            return ResponseEntity.ok(countSalarie);
        else
            throw new Exception("Aucun salarié");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto saveSalarie(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto updateSalarie(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }
    
    @PutMapping(value="/without-password",consumes = "application/json", produces = "application/json")
    public SalarieDto updateWithoutPasswordSalarie(@RequestBody SalarieDto salarieDto) {
        return salarieService.updateWithoutPassword(salarieDto);
    }

    @GetMapping(value = "/liste/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalariesWithPosteByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<SalarieListeDto> salarie = salarieService.getAllSalariesWithPosteByPage(page, size);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié avec un poste pour la taille : " + size + " et la page : " + page);
    }
    
    @GetMapping(value = "/salaries-domaine-competence/{domaine}/{competence}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalariesByDomaineAndCompetence(@PathVariable("domaine") long domaine,
            @PathVariable(value = "competence") List<Long> competence) throws Exception {
        System.out.println("comp : "+competence+" || dom : "+domaine);
        
        List<SalarieDto> salarie = salarieService.getAllSalariesByDomaineAndCompetence(domaine, competence);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié avec le domaine : " + domaine + " et les comptences : " + competence);
    }
    
    @GetMapping(value = "/salaries-sans-poste-domaine-competence/{domaine}/{competence}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllSalariesWithoutPosteByDomaineAndCompetence(@PathVariable("domaine") long domaine,
            @PathVariable(value = "competence") List<Long> competence) throws Exception {
        System.out.println("comp : "+competence+" || dom : "+domaine);
        
        List<SalarieDto> salarie = salarieService.getAllSalariesWithoutPosteByDomaineAndCompetence(domaine, competence);
        if (salarie != null)
            return ResponseEntity.ok(salarie);
        else
            throw new Exception("Aucun salarié avec le domaine : " + domaine + " et les comptences : " + competence);
    }

}
