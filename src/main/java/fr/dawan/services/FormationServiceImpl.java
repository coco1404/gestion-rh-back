package fr.dawan.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.FormationDto;
import fr.dawan.entities.Formation;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.FormationRepository;

@Service
@Transactional
public class FormationServiceImpl implements FormationService {

    @Autowired
    FormationRepository formationRepository;
    
    @Override
    public List<FormationDto> getAllFormation(int page, int size) {
        List<Formation> lst = formationRepository.findAll(PageRequest.of(page, size)).get().collect(Collectors.toList());
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

    @Override
    public List<FormationDto> getAllFormationEnCours(int page, int size) {
        List<Formation> lst = formationRepository.getAllFormationEnCours(PageRequest.of(page, size));
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

    @Override
    public List<FormationDto> getAllFormationNonCommence(int page, int size) {
        List<Formation> lst = formationRepository.getAllFormationNonCommence(PageRequest.of(page, size));
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

    @Override
    public List<FormationDto> getAllFormationByIdCompetence(long idCompetence) {
        List<Formation> lst = formationRepository.getAllFormationByIdCompetence(idCompetence);
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

    @Override
    public List<FormationDto> getAllFormationByDate(Date date) {
        List<Formation> lst = formationRepository.getAllFormationByDate(date);
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

    @Override
    public void deleteById(long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public FormationDto saveOrUpdate(FormationDto formationDto) {
        Formation f = MapperCommun.convert(formationDto, Formation.class);
        f = formationRepository.saveAndFlush(f);
        return MapperCommun.convert(f, FormationDto.class);
    }

    @Override
    public List<FormationDto> getAllFormationByPeriode(Date dateDebut, Date dateFin) {
        List<Formation> lst = formationRepository.getAllFormationByPeriode(dateDebut, dateFin);
        List<FormationDto> result = new ArrayList<FormationDto>();
        for (Formation c : lst) {
            result.add(MapperCommun.convert(c, FormationDto.class));
        }
        return result;
    }

}
