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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.services.SalarieService;

@RestController
@RequestMapping("/api/salaries")
public class SalarieController {
    
    @Autowired
    private SalarieService salarieService;
    
    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<SalarieDto> getAllSalaries() {
        return salarieService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getAllSalariesByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return salarieService.getAllSalaries(page, size);
    }
    
    @GetMapping(value = "/adresse/{id}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getSalariesByAdresse(@PathVariable("id") long id) {
        return salarieService.findAllSalariesByAdresse(id);
    }
    
    @GetMapping(value = "/domaine/{id}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getSalariesByDomaine(@PathVariable("id") long id) {
        return salarieService.findAllSalariesByDomaine(id);
    }
    
    @GetMapping(value = "/entreprise/{id}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getSalariesByEntreprise(@PathVariable("id") long id) {
        return salarieService.findAllSalariesByEntreprise(id);
    }
    
    @GetMapping(value = "/poste/{id}", produces = "application/json")
    public @ResponseBody List<SalarieDto> getSalariesByPoste(@PathVariable("id") long id) {
        return salarieService.findAllSalariesByPoste(id);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public SalarieDto getEntretienById(@PathVariable("id") long id) {
        return salarieService.findById(id);
    }
    
    @GetMapping(value = "/{id}/formations", produces = "application/json")
    public @ResponseBody List<FormationDto> getFormationBySalarie(@PathVariable("id") long id) {
        return salarieService.findFormationBySalarie(id);
    }
    
    @GetMapping(value = "/{id}/roles", produces = "application/json")
    public @ResponseBody List<RoleDto> getRoleBySalarie(@PathVariable("id") long id) {
        return salarieService.findRoleBySalarie(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto saveEntretien(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto updateEntretien(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }

    
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
        try {
            salarieService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
