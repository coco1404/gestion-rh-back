package fr.dawan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import fr.dawan.services.SalarieService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/salaries")
public class SalarieController {
    
    @Autowired
    private SalarieService salarieService;
    
    @GetMapping(produces = "application/json")
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
        return salarieService.findAllSalariesByTitrePoste(id);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public SalarieDto getSalarieById(@PathVariable("id") long id) {
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
    
    @GetMapping(value = "/{id}/competences", produces = "application/json")
    public @ResponseBody List<CompetenceDto> getCompetenceBySalarie(@PathVariable("id") long id) {
        return salarieService.findCompetenceBySalarie(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto saveSalarie(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public SalarieDto updateSalarie(@RequestBody SalarieDto salarieDto) {
        return salarieService.saveOrUpdate(salarieDto);
    }

}
