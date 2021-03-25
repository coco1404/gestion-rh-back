package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.DomaineDto;
import fr.dawan.entities.Domaine;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.DomaineRepository;

@Service
@Transactional
public class DomaineServiceImpl implements DomaineService{
    
    @Autowired
    private DomaineRepository domaineRepository;

    @Override
    public List<DomaineDto> findAll() {
        List<Domaine> lst = domaineRepository.findAll();
        List<DomaineDto> result = new ArrayList<DomaineDto>();
        for(Domaine d : lst) {
         result.add(MapperCommun.convert(d, DomaineDto.class));
        }
        return result;
    }

    @Override
    public List<DomaineDto> getAllDomaines(int page, int max) {
        List<Domaine> lst = domaineRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<DomaineDto> result = new ArrayList<DomaineDto>();
        for(Domaine d : lst) {
         result.add(MapperCommun.convert(d, DomaineDto.class));
        }
        return result;
    }

    @Override
    public DomaineDto getById(long id) {
        Optional<Domaine> domaine = domaineRepository.findById(id);
        if(domaine.isPresent()) {
            return MapperCommun.convert(domaine.get(), DomaineDto.class);
        }
        return null;
    }
    
    @Override
    public List<DomaineDto> findByName(String name) {
        List<Domaine> domaine = domaineRepository.findByName(name.toLowerCase());
        List<DomaineDto> result = new ArrayList<DomaineDto>();
        for(Domaine d : domaine) {
         result.add(MapperCommun.convert(d, DomaineDto.class));
        }
        return result;
    }

    @Override
    public void deleteById(long id) {
        domaineRepository.deleteById(id);
    }

    @Override
    public DomaineDto saveOrUpdate(DomaineDto dDto) {
        Domaine domaine = MapperCommun.convert(dDto, Domaine.class);
        domaine = domaineRepository.saveAndFlush(domaine);
        return MapperCommun.convert(domaine, DomaineDto.class);
    }

    @Override
    public long countDomaine() {
        return domaineRepository.count();
    }



}
