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

import fr.dawan.dto.TitrePosteDto;
import fr.dawan.services.TitrePosteService;

@RestController
@RequestMapping("/api/titrepostes")
public class TitrePosteController {
    
    @Autowired
    private TitrePosteService titrePosteService;
    
    
    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<TitrePosteDto> getAllTitrePoste() {
        return titrePosteService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<TitrePosteDto> getAllTitrePosteByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return titrePosteService.getAllTitresPostes(page, size);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public TitrePosteDto getTitrePosteById(@PathVariable("id") long id) {
        return titrePosteService.findById(id);// status = ok, body (objet retourné)
    }
    
    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public TitrePosteDto getTypeContratByName(@RequestParam("name") String name) {
        return titrePosteService.findByName(name);
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public TitrePosteDto saveTitrePoste(@RequestBody TitrePosteDto tpDto) {
        return titrePosteService.saveOrUpdate(tpDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public TitrePosteDto updateTitrePoste(@RequestBody TitrePosteDto tpDto) {
        return titrePosteService.saveOrUpdate(tpDto);
    }

    
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteTitrePosteById(@PathVariable(value = "id") long id) {
        try {
            titrePosteService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
