package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.dto.SalarieListeDto;
import fr.dawan.entities.Competence;
import fr.dawan.entities.Formation;
import fr.dawan.entities.Poste;
import fr.dawan.entities.Role;
import fr.dawan.entities.Salarie;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.CompetenceRepository;
import fr.dawan.repositories.FormationRepository;
import fr.dawan.repositories.PosteRepository;
import fr.dawan.repositories.RoleRepository;
import fr.dawan.repositories.SalarieRepository;

@Service
@Transactional
public class SalarieServiceImpl implements SalarieService {

    @Autowired
    private SalarieRepository salarieRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PosteRepository posteRepository;

    @Override
    public List<SalarieDto> findAll() {
        List<Salarie> lst = salarieRepository.findAll();
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> getAllSalaries(int page, int max) {
        List<Salarie> lst = salarieRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByAdresse(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByAdresse(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByDomaine(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByDomaine(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByEntreprise(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByEntreprise(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public List<SalarieDto> findAllSalariesByTitrePoste(long id) {
        List<Salarie> lst = salarieRepository.findAllSalariesByTitrePoste(id);
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }

    @Override
    public SalarieDto findById(long id) {
        Optional<Salarie> salarie = salarieRepository.findById(id);
        if (salarie.isPresent()) {
            return MapperCommun.convert(salarie.get(), SalarieDto.class);
        }
        return null;
    }

    @Override
    public SalarieDto saveOrUpdate(SalarieDto salarieDto) {
        Salarie salarie = MapperCommun.convert(salarieDto, Salarie.class);
        salarie = salarieRepository.saveAndFlush(salarie);
        return MapperCommun.convert(salarie, SalarieDto.class);
    }
    
    @Override
    public SalarieDto updateWithoutPassword(SalarieDto salarieDto) {
        Salarie salarie = MapperCommun.convert(salarieDto, Salarie.class);
        Optional<Salarie> oldSalarieOpt = salarieRepository.findById(salarieDto.getId());
        if(oldSalarieOpt.isPresent()) {
            Salarie _salarie = oldSalarieOpt.get();
            salarie.setMotDePasse(_salarie.getMotDePasse());
        }
        salarie = salarieRepository.saveAndFlush(salarie);
        return MapperCommun.convert(salarie, SalarieDto.class);
    }

    @Override
    public List<FormationDto> findFormationBySalarie(long id) {
        List<Formation> lst = formationRepository.findFormationBySalarie(id);
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation formation : lst) {
            result.add(MapperCommun.convert(formation, FormationDto.class));
        }
        return result;
    }

    @Override
    public List<RoleDto> findRoleBySalarie(long id) {
        List<Role> lst = roleRepository.findRoleBySalarie(id);
        List<RoleDto> result = new ArrayList<RoleDto>();
        for (Role role : lst) {
            result.add(MapperCommun.convert(role, RoleDto.class));
        }
        return result;
    }

    @Override
    public List<CompetenceDto> findCompetenceBySalarie(long id) {
        List<Competence> lst = competenceRepository.findCompetenceBySalarie(id);
        List<CompetenceDto> result = new ArrayList<CompetenceDto>();
        for (Competence competence : lst) {
            result.add(MapperCommun.convert(competence, CompetenceDto.class));
        }
        return result;
    }

    @Override
    public SalarieDto findByEmail(String email) {
        Salarie s = salarieRepository.findByEmail(email);
        if (s != null)
            return MapperCommun.convert(s, SalarieDto.class);

        return null;
    }

    @Override
    public List<SalarieListeDto> getAllSalariesWithPosteByPage(int page, int size) {
        List<Poste> lst = posteRepository.getAllSalariesWithPosteByPage(PageRequest.of(page, size));
        List<SalarieListeDto> result = new ArrayList<SalarieListeDto>();
        long idSalarie=0;
        for (Poste competence : lst) {
            if(competence.getSalarie().getId()!=idSalarie)
                result.add(MapperCommun.convert(competence, SalarieListeDto.class));
            idSalarie=competence.getId();
        }
        return result;
    }

    @Override
    public long countSalarie() {
        return salarieRepository.count();
    }

    @Override
    public List<SalarieDto> getAllSalariesWithoutPoste() {
        List<Salarie> lst = salarieRepository.findAllWithoutPoste();
        List<SalarieDto> result = new ArrayList<SalarieDto>();
        for (Salarie salarie : lst) {
            result.add(MapperCommun.convert(salarie, SalarieDto.class));
        }
        return result;
    }



}
