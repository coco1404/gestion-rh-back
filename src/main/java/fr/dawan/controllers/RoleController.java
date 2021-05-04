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

import fr.dawan.dto.RoleDto;
import fr.dawan.services.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllRoles() throws Exception {
        List<RoleDto> role = roleService.findAll();
        if (role != null)
            return ResponseEntity.ok(role);
        else
            throw new Exception("Aucun role");
    }

    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody ResponseEntity<?> getAllRolesPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) throws Exception {
        List<RoleDto> role = roleService.getAllRoles(page, size);
        if (role != null)
            return ResponseEntity.ok(role);
        else
            throw new Exception("Aucun role pour la taille : " + size + " et la page : " + page);
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getRoleById(@PathVariable("id") long id) throws Exception {
        RoleDto role = roleService.findById(id);// status = ok, body (objet retourné)
        if (role != null)
            return ResponseEntity.ok(role);
        else
            throw new Exception("Aucun role pour l'id : " + id);
    }

    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> getRoleByName(@RequestParam("name") String name) throws Exception {
        List<RoleDto> role = roleService.findByName(name);
        if (role != null)
            return ResponseEntity.ok(role);
        else
            throw new Exception("Aucun role pour la recherche : " + name);
    }
    
    @GetMapping(value = "/count", produces = { "application/json", "application/xml" })
    public ResponseEntity<?> countRole() throws Exception {
        long countRole = roleService.countRole();
        if (countRole > 0)
            return ResponseEntity.ok(countRole);
        else
            throw new Exception("Aucun role");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public RoleDto saveRole(@RequestBody RoleDto rDto) {
        System.out.println("rolewww : "+rDto.getTitre()+" || "+rDto.getId());
        return roleService.saveOrUpdate(rDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public RoleDto updateRole(@RequestBody RoleDto rDto) {
        return roleService.saveOrUpdate(rDto);
    }

    @DeleteMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<?> deleteRoleById(@PathVariable(value = "id") long id) {
        try {
            roleService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Suppr effectuée");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Suppr non réalisée");
        }
    }
}
