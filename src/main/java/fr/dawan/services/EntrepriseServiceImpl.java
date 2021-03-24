package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.EntrepriseDto;
import fr.dawan.entities.Entreprise;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.EntrepriseRepository;

@Service
@Transactional
public class EntrepriseServiceImpl implements EntrepriseService{
    
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override
    public List<EntrepriseDto> findAll() {
        List<Entreprise> lst = entrepriseRepository.findAll();
        List<EntrepriseDto> result = new ArrayList<EntrepriseDto>();
        for(Entreprise e : lst) {
         result.add(MapperCommun.convert(e, EntrepriseDto.class));
        }
        return result;
    }

    @Override
    public List<EntrepriseDto> getAllEntreprises(int page, int max) {
        List<Entreprise> lst = entrepriseRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<EntrepriseDto> result = new ArrayList<EntrepriseDto>();
        for(Entreprise entreprise : lst) {
         result.add(MapperCommun.convert(entreprise, EntrepriseDto.class));
        }
        return result;
    }

    @Override
    public EntrepriseDto findById(long id) {
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        if(entreprise.isPresent()) {
            return MapperCommun.convert(entreprise.get(), EntrepriseDto.class);
        }
        return null;
    }

    @Override
    public List<EntrepriseDto> findByName(String name) {
        List<Entreprise> lst = entrepriseRepository.findByName(name.toLowerCase());
        List<EntrepriseDto> result = new ArrayList<EntrepriseDto>();
        for(Entreprise entreprise : lst) {
         result.add(MapperCommun.convert(entreprise, EntrepriseDto.class));
        }
        return result;
    }

    @Override
    public EntrepriseDto findByAdresseId(long id) {
        Entreprise entreprise = entrepriseRepository.findByAdresseId(id);
        if(entreprise != null) {
            return MapperCommun.convert(entreprise, EntrepriseDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        entrepriseRepository.deleteById(id);
    }

    @Override
    public EntrepriseDto saveOrUpdate(EntrepriseDto rDto) {
        Entreprise entreprise = MapperCommun.convert(rDto, Entreprise.class);
        entreprise = entrepriseRepository.saveAndFlush(entreprise);
        return MapperCommun.convert(entreprise, EntrepriseDto.class);
    }

}
