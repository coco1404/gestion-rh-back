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
    public ResponseEntity<?> getCompteRenduById(@PathVariable("idCompteRendu") long idCompteRendu) throws Exception {
        CompteRenduDto compteRendu = compteRenduService.getCompteRenduById(idCompteRendu);
        if (compteRendu != null)
            return ResponseEntity.ok(compteRendu);
        else
            throw new Exception("Aucun compte rendu avec l'id : " + idCompteRendu);
    }

    @GetMapping(value = "/entretien/{idEntretien}", produces = "application/json")
    public ResponseEntity<?> getCompteRenduByEntretien(@PathVariable("idEntretien") long idEntretien) throws Exception {
        List<CompteRenduDto> compteRendu = compteRenduService.getCompteRenduByIdEntretien(idEntretien);
        if (compteRendu != null)
            return ResponseEntity.ok(compteRendu);
        else
            throw new Exception("Aucun compte rendu pour l'id entretien : " + idEntretien);
    }

    @GetMapping(value = "/manager/{idManager}", produces = "application/json")
    public ResponseEntity<?> getCompteRenduByManager(@PathVariable("idManager") long idManager) throws Exception {
        List<CompteRenduDto> compteRendu = compteRenduService.getCompteRenduByIdManagerEntretien(idManager);
        if (compteRendu != null)
            return ResponseEntity.ok(compteRendu);
        else
            throw new Exception("Aucun compte rendu pour l'id manager : " + idManager);
    }

    @GetMapping(value = "/salarie/{idSalarie}", produces = "application/json")
    public ResponseEntity<?> getCompteRenduBySalarie(@PathVariable("idSalarie") long idSalarie) throws Exception {
        List<CompteRenduDto> compteRendu = compteRenduService.getCompteRenduByIdSalarie(idSalarie);
        if (compteRendu != null)
            return ResponseEntity.ok(compteRendu);
        else
            throw new Exception("Aucun compte rendu pour l'id salarié : " + idSalarie);
    }
    
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> countCompteRendu() throws Exception {
        long countCompteRendu = compteRenduService.countCompteRendu();
        if (countCompteRendu > 0)
            return ResponseEntity.ok(countCompteRendu);
        else
            throw new Exception("Aucun compte rendu");
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
