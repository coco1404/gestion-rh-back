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

import fr.dawan.dto.AdresseDto;
import fr.dawan.services.AdresseService;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;
    
    
    @GetMapping(produces = "application/json")
    public @ResponseBody List<AdresseDto> getAllAdresse() {
        return adresseService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<AdresseDto> getAllAdresseByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return adresseService.getAllAdresses(page, size);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public AdresseDto getAdresseById(@PathVariable("id") long id) {
        return adresseService.getById(id);// status = ok, body (objet retourné)
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public AdresseDto saveAdresse(@RequestBody AdresseDto aDto) {
        return adresseService.saveOrUpdate(aDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public AdresseDto updateAdresse(@RequestBody AdresseDto aDto) {
        return adresseService.saveOrUpdate(aDto);
    }

    
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
        try {
            adresseService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
