package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.RoleDto;

public interface RoleService {
    List<RoleDto> findAll();
    List<RoleDto> getAllRoles(int page, int max);
    List<RoleDto> findByName(String name);
    RoleDto findById(long id);
    void deleteById(long id);
    RoleDto saveOrUpdate(RoleDto rDto);
    long countRole();
}
