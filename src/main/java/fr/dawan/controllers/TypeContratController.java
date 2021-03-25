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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.dto.TypeContratDto;
import fr.dawan.services.TypeContratService;

@RestController
@RequestMapping("/api/typecontrats")
public class TypeContratController {
    @Autowired
    private TypeContratService typeContratService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllTypeContrat() throws Exception {
        List<TypeContratDto> typeContrat = typeContratService.findAll();
        if (typeContrat != null)
            return ResponseEntity.ok(typeContrat);
        else
            throw new Exception("Aucun type de contrat");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllTypeContratByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<TypeContratDto> typeContrat = typeContratService.getAllTypeContracts(page, size);
        if (typeContrat != null)
            return ResponseEntity.ok(typeContrat);
        else
            throw new Exception("Aucun type de contrat pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getTypeContratById(@PathVariable("id") long id) throws Exception {
        TypeContratDto typeContrat = typeContratService.findById(id);// status = ok, body (objet retourné)
        if (typeContrat != null)
            return ResponseEntity.ok(typeContrat);
        else
            throw new Exception("Aucun type de contrat pour l'id : " + id);
    }

    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getTypeContratByName(@RequestParam("name") String name) throws Exception {
        List<TypeContratDto> typeContrat = typeContratService.findByName(name);
        if (typeContrat != null)
            return ResponseEntity.ok(typeContrat);
        else
            throw new Exception("Aucun type de contrat pour la recherche : " + name);
    }

    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countTypeContrat() throws Exception {
        long countTypeContrat = typeContratService.countTypeContrat();
        if (countTypeContrat > 0)
            return ResponseEntity.ok(countTypeContrat);
        else
            throw new Exception("Aucun type de contrat");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public TypeContratDto saveTypeContrat(@RequestBody TypeContratDto tcDto) {
        return typeContratService.saveOrUpdate(tcDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public TypeContratDto updateTypeContrat(@RequestBody TypeContratDto tcDto) {
        return typeContratService.saveOrUpdate(tcDto);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteTypeContratById(@PathVariable(value = "id") long id) {
        try {
            typeContratService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
