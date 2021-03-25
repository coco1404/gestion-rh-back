package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.RoleDto;
import fr.dawan.entities.Role;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll() {
        List<Role> lst = roleRepository.findAll();
        List<RoleDto> result = new ArrayList<RoleDto>();
        for(Role role : lst) {
         result.add(MapperCommun.convert(role, RoleDto.class));
        }
        return result;
    }

    @Override
    public List<RoleDto> getAllRoles(int page, int max) {
        List<Role> lst = roleRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<RoleDto> result = new ArrayList<RoleDto>();
        for(Role role : lst) {
         result.add(MapperCommun.convert(role, RoleDto.class));
        }
        return result; 
    }

    @Override
    public List<RoleDto> findByName(String name) {
        List<Role> lst = roleRepository.findByName(name.toLowerCase());
        List<RoleDto> result = new ArrayList<RoleDto>();
        for(Role role : lst) {
         result.add(MapperCommun.convert(role, RoleDto.class));
        }
        return result; 
    }

    @Override
    public RoleDto findById(long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()) {
            return MapperCommun.convert(role.get(), RoleDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
        
    }

    @Override
    public RoleDto saveOrUpdate(RoleDto rDto) {
        Role role = MapperCommun.convert(rDto, Role.class);
        role = roleRepository.saveAndFlush(role);
        return MapperCommun.convert(role, RoleDto.class);
    }

    @Override
    public long countRole() {
        return roleRepository.count();
    }

}
