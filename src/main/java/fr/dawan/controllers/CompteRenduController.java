package fr.dawan.controllers;

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

import fr.dawan.dto.CompteRenduDto;
import fr.dawan.services.CompteRenduService;

@RestController
@RequestMapping("/api/compterendus")
public class CompteRenduController {
    
    @Autowired
    CompteRenduService compteRenduService;
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CompteRenduDto savePoste(@RequestBody CompteRenduDto cpDto) {
        return compteRenduService.saveOrUpdate(cpDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public CompteRenduDto updatePoste(@RequestBody CompteRenduDto cpDto) {
        return compteRenduService.saveOrUpdate(cpDto);
    }
    
    @GetMapping(value = "/{idCompteRendu}", produces = "application/json")
    public CompteRenduDto getAllPosteByTypeContrat(@PathVariable("idCompteRendu") long idCompteRendu) {
        return compteRenduService.getCompteRenduById(idCompteRendu);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteByIdPoste(@PathVariable(value = "id", required = true) long id) {
        try {
            compteRenduService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }
}
