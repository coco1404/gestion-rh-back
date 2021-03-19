package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.entities.Role;
import fr.dawan.entities.Salarie;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.CompetenceRepository;
import fr.dawan.repositories.FormationRepository;
import fr.dawan.repositories.RoleRepository;
import fr.dawan.repositories.SalarieRepository;

@Service
@Transactional
public class SalarieServiceImpl implements SalarieService{
    
    @Autowired
    private SalarieRepository salarieRepository;
    
    @Autowired
    private FormationRepository formationRepository;
    
    @Autowired
    private CompetenceRepository competenceRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public List<SalarieDto> findAll() {
        List<Salarie> lst = salarieRepository.findAll();
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> getAllSalaries(int page, int max) {
        List<Salarie> lst = salarieRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByAdresse(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByAdresse(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByDomaine(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByDomaine(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByEntreprise(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByEntreprise(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByPoste(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByPoste(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for(Salarie salarie : lst) {
         result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public SalarieDto findById(long id) {
        Optional<Salarie> salarie = salarieRepository.findById(id);
        if(salarie.isPresent()) {
            return MapperCommun.convert(salarie.get(), SalarieDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        salarieRepository.deleteById(id);
    }

    @Override
    public SalarieDto saveOrUpdate(SalarieDto salarieDto) {
        Salarie salarie = MapperCommun.convert(salarieDto, Salarie.class);
        salarie = salarieRepository.saveAndFlush(salarie);
        return MapperCommun.convert(salarie, SalarieDto.class);
    }

    @Override
    public List<FormationDto> findFormationBySalarie(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoleDto> findRoleBySalarie(long id) {
        List<Role> lst = roleRepository.findRoleBySalarie(id);
        List<RoleDto> result = new ArrayList<RoleDto>();
        for(Role role : lst) {
         result.add(MapperCommun.convert(role, RoleDto.class));
        }
        return result;
    }
    
    


}
