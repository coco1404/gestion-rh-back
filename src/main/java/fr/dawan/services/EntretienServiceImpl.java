package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.EntretienDto;
import fr.dawan.entities.Entretien;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.EntretienRepository;

@Service
@Transactional
public class EntretienServiceImpl implements EntretienService{
    
    @Autowired
    private EntretienRepository entretienRepository;

    @Override
    public List<EntretienDto> findAll() {
        List<Entretien> lst = entretienRepository.findAll();
        List<EntretienDto> result = new ArrayList<EntretienDto>();
        for(Entretien entretien : lst) {
         result.add(MapperCommun.convert(entretien, EntretienDto.class));
        }
        return result;
    }

    @Override
    public List<EntretienDto> getAllEntretien(int page, int max) {
        List<Entretien> lst = entretienRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<EntretienDto> result = new ArrayList<EntretienDto>();
        for(Entretien entretien : lst) {
         result.add(MapperCommun.convert(entretien, EntretienDto.class));
        }
        return result;
    }

    @Override
    public List<EntretienDto> getByManager(long id) {
        List<Entretien> lst = entretienRepository.getByManager(id);
        List<EntretienDto> result = new ArrayList<EntretienDto>();
        for(Entretien entretien : lst) {
         result.add(MapperCommun.convert(entretien, EntretienDto.class));
        }
        return result;
    }

    @Override
    public List<EntretienDto> getBySalarie(long id) {
        List<Entretien> lst = entretienRepository.getBySalarie(id);
        List<EntretienDto> result = new ArrayList<EntretienDto>();
        for(Entretien entretien : lst) {
         result.add(MapperCommun.convert(entretien, EntretienDto.class));
        }
        return result;
    }

    @Override
    public EntretienDto findById(long id) {
        Optional<Entretien> entretien = entretienRepository.findById(id);
        if(entretien.isPresent()) {
            return MapperCommun.convert(entretien.get(), EntretienDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        entretienRepository.deleteById(id);
    }

    @Override
    public EntretienDto saveOrUpdate(EntretienDto entretienDto) {
        Entretien entretien = MapperCommun.convert(entretienDto, Entretien.class);
        entretien = entretienRepository.saveAndFlush(entretien);
        return MapperCommun.convert(entretien, EntretienDto.class);
    }

}
