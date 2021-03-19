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
    
    
    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<RoleDto> getAllRoles() {
        return roleService.findAll();
    }
    
    @GetMapping(value = "/{page}/{size}", produces = "application/json")
    public @ResponseBody List<RoleDto> getAllRolesPage(@PathVariable("page") int page,
            @PathVariable(value = "size") int size) {
        return roleService.getAllRoles(page, size);
    }
    
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
    public RoleDto getRoleById(@PathVariable("id") long id) {
        return roleService.findById(id);// status = ok, body (objet retourné)
    }
    
    @GetMapping(value = "/search", produces = { "application/json", "application/xml" })
    public RoleDto getRoleByName(@RequestParam("name") String name) {
        return roleService.findByName(name);
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public RoleDto saveRole(@RequestBody RoleDto rDto) {
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
