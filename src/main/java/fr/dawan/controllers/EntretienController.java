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

import fr.dawan.dto.EntretienDto;
import fr.dawan.services.EntretienService;

@RestController
@RequestMapping("/api/entretiens")
public class EntretienController {
    
    @Autowired
    private EntretienService entretienService;
    
    
    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllEntretiens() throws Exception {
        List<EntretienDto> entretien = entretienService.findAll();
        if(entretien != null)
            return ResponseEntity.ok(entretien);
        else
            throw new Exception("Aucun entretien");
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllEntretiensByPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<EntretienDto> entretien = entretienService.getAllEntretien(page, size);
        if(entretien != null)
            return ResponseEntity.ok(entretien);
        else
            throw new Exception("Aucun entretien pour la taille : "+size+" et la page : "+page);
    }
    
//    @GetMapping(value = "/{date}", produces = { "application/json", "application/xml" })
//    public AdresseDto getEntretienByDate(@PathVariable("date") Date date) {
//        return entretienService.getByDate(date);// status = ok, body (objet retourné)
//    }
    
    @GetMapping(value = "/manager/{id}", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<?> getEntretienByManager(@PathVariable("id") long id) throws Exception {
        List<EntretienDto> entretien = entretienService.getByManager(id);
        if(entretien != null)
            return ResponseEntity.ok(entretien);
        else
            throw new Exception("Aucun entretien pour l'id manager : "+id);
    }
    
    @GetMapping(value = "/salarie/{id}", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<?> getEntretienBySalarie(@PathVariable("id") long id) throws Exception {
        List<EntretienDto> entretien =  entretienService.getBySalarie(id);
        if(entretien != null)
            return ResponseEntity.ok(entretien);
        else
            throw new Exception("Aucun entretien pour l'id salarié : "+id);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getEntretienById(@PathVariable("id") long id) throws Exception {
        EntretienDto entretien = entretienService.findById(id);
        if(entretien != null)
            return ResponseEntity.ok(entretien);
        else
            throw new Exception("Aucun entretien pour l'id : "+id);
    }

    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countEntretien() throws Exception {
        long countEntretien = entretienService.countEntretien();
        if(countEntretien > 0)
            return ResponseEntity.ok(countEntretien);
        else
            throw new Exception("Aucun entretien");
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public EntretienDto saveEntretien(@RequestBody EntretienDto entretienDto) {
        return entretienService.saveOrUpdate(entretienDto);
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    public EntretienDto updateEntretien(@RequestBody EntretienDto entretienDto) {
        return entretienService.saveOrUpdate(entretienDto);
    }

    
    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") long id) {
        try {
            entretienService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
