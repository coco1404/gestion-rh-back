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

import fr.dawan.dto.CompteRenduDto;
import fr.dawan.services.CompteRenduService;

@RestController
@RequestMapping("/api/compterendus")
public class CompteRenduController {
    
    @Autowired
    CompteRenduService compteRenduService;
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CompteRenduDto saveCompteRendu(@RequestBody CompteRenduDto cpDto) {
        return compteRenduService.saveOrUpdate(cpDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public CompteRenduDto updateConpteRendu(@RequestBody CompteRenduDto cpDto) {
        return compteRenduService.saveOrUpdate(cpDto);
    }
    
    @GetMapping(value = "/{idCompteRendu}", produces = "application/json")
    public CompteRenduDto getCompteRenduById(@PathVariable("idCompteRendu") long idCompteRendu) {
        return compteRenduService.getCompteRenduById(idCompteRendu);
    }
    
    @GetMapping(value = "/entretien/{idEntretien}", produces = "application/json")
    public List<CompteRenduDto> getCompteRenduByEntretien(@PathVariable("idEntretien") long idEntretien) {
        return compteRenduService.getCompteRenduByIdEntretien(idEntretien);
    }
    
    @GetMapping(value = "/manager/{idManager}", produces = "application/json")
    public List<CompteRenduDto> getCompteRenduByManager(@PathVariable("idManager") long idManager) {
        return compteRenduService.getCompteRenduByIdManagerEntretien(idManager);
    }
    
    @GetMapping(value = "/salarie/{idSalarie}", produces = "application/json")
    public List<CompteRenduDto> getCompteRenduBySalarie(@PathVariable("idSalarie") long idSalarie) {
        return compteRenduService.getCompteRenduByIdSalarie(idSalarie);
    }
    
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id", required = true) long id) {
        try {
            compteRenduService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Suppresion effectuée");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppresion non réalisée");
        }
    }
}
