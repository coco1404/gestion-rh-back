package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.entities.Competence;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.CompetenceRepository;

@Service
@Transactional
public class CompetenceServiceImpl implements CompetenceService {
    @Autowired
    CompetenceRepository competenceRepository;
    
    @Override
    public List<CompetenceDto> getAllComptence() {
        List<Competence> lst = competenceRepository.findAll();
        List<CompetenceDto> result = new ArrayList<CompetenceDto>();
        for (Competence c : lst) {
            result.add(MapperCommun.convert(c, CompetenceDto.class));
        }
        return result;
    }

    @Override
    public CompetenceDto saveOrUpdate(CompetenceDto competenceDto) {
        Competence c = MapperCommun.convert(competenceDto, Competence.class);
        c = competenceRepository.saveAndFlush(c);
        return MapperCommun.convert(c, CompetenceDto.class);
    }

    @Override
    public void delete(CompetenceDto comptenceDto) {
        Competence c = MapperCommun.convert(comptenceDto, Competence.class);
        competenceRepository.delete(c);
    }

    @Override
    public List<CompetenceDto> getComptenceByIdPoste(long idPoste) {
        List<Competence> lst = competenceRepository.getComptenceByIdPoste(idPoste);
        List<CompetenceDto> result = new ArrayList<CompetenceDto>();
        for (Competence c : lst) {
            result.add(MapperCommun.convert(c, CompetenceDto.class));
        }
        return result;
    }

    @Override
    public void deleteById(long idCompetence) {
        competenceRepository.deleteById(idCompetence);
    }

}
