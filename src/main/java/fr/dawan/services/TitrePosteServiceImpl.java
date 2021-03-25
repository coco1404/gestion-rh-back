package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.TitrePosteDto;
import fr.dawan.entities.TitrePoste;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.TitrePosteRepository;

@Service
@Transactional
public class TitrePosteServiceImpl implements TitrePosteService{
    
    @Autowired
    private TitrePosteRepository titrePosteRepository;

    @Override
    public List<TitrePosteDto> findAll() {
        List<TitrePoste> lst = titrePosteRepository.findAll();
        List<TitrePosteDto> result = new ArrayList<TitrePosteDto>();
        for(TitrePoste tp : lst) {
         result.add(MapperCommun.convert(tp, TitrePosteDto.class));
        }
        return result;
    }

    @Override
    public List<TitrePosteDto> getAllTitresPostes(int page, int max) {
        List<TitrePoste> lst = titrePosteRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<TitrePosteDto> result = new ArrayList<TitrePosteDto>();
        for(TitrePoste tp : lst) {
         result.add(MapperCommun.convert(tp, TitrePosteDto.class));
        }
        return result; 
    }

    @Override
    public List<TitrePosteDto> findByName(String name) {
        List<TitrePoste> lst = titrePosteRepository.findByName(name.toLowerCase());
        List<TitrePosteDto> result = new ArrayList<TitrePosteDto>();
        for(TitrePoste tp : lst) {
         result.add(MapperCommun.convert(tp, TitrePosteDto.class));
        }
        return result; 
    }

    @Override
    public TitrePosteDto findById(long id) {
        Optional<TitrePoste> tp = titrePosteRepository.findById(id);
        if(tp.isPresent()) {
            return MapperCommun.convert(tp.get(), TitrePosteDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        titrePosteRepository.deleteById(id);
        
    }

    @Override
    public TitrePosteDto saveOrUpdate(TitrePosteDto tpDto) {
        TitrePoste tp = MapperCommun.convert(tpDto, TitrePoste.class);
        tp = titrePosteRepository.saveAndFlush(tp);
        return MapperCommun.convert(tp, TitrePosteDto.class);
    }

    @Override
    public long countTitrePoste() {
        return titrePosteRepository.count();
    }

}
