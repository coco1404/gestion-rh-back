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
    public @ResponseBody List<TypeContratDto> getAllTypeContrat() {
        return typeContratService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<TypeContratDto> getAllTypeContratByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return typeContratService.getAllTypeContracts(page, size);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public TypeContratDto getTypeContratById(@PathVariable("id") long id) {
        return typeContratService.findById(id);// status = ok, body (objet retourné)
    }
    
    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public TypeContratDto getTypeContratByName(@RequestParam("name") String name) {
        return typeContratService.findByName(name);
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
