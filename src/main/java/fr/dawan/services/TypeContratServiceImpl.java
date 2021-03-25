package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.TypeContratDto;
import fr.dawan.entities.TypeContrat;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.TypeContratRepository;

@Service
@Transactional
public class TypeContratServiceImpl implements TypeContratService{
    
    @Autowired
    private TypeContratRepository typeContratRepository;
    
    @Override
    public List<TypeContratDto> findAll() {
        List<TypeContrat> lst = typeContratRepository.findAll();
        List<TypeContratDto> result = new ArrayList<TypeContratDto>();
        for(TypeContrat tc : lst) {
         result.add(MapperCommun.convert(tc, TypeContratDto.class));
        }
        return result;
    }

    @Override
    public List<TypeContratDto> getAllTypeContracts(int page, int max) {
        List<TypeContrat> lst = typeContratRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<TypeContratDto> result = new ArrayList<TypeContratDto>();
        for(TypeContrat tc : lst) {
         result.add(MapperCommun.convert(tc, TypeContratDto.class));
        }
        return result; 
    }

    @Override
    public TypeContratDto findById(long id) {
        Optional<TypeContrat> tc = typeContratRepository.findById(id);
        if(tc.isPresent()) {
            return MapperCommun.convert(tc.get(), TypeContratDto.class);
        }
        return null;
    }
    
    @Override
    public List<TypeContratDto> findByName(String type) {
        List<TypeContrat> lst = typeContratRepository.findByName(type.toLowerCase());
        List<TypeContratDto> result = new ArrayList<TypeContratDto>();
        for(TypeContrat tc : lst) {
         result.add(MapperCommun.convert(tc, TypeContratDto.class));
        }
        return result; 
    }


    @Override
    public void deleteById(long id) {
        typeContratRepository.deleteById(id);
        
    }

    @Override
    public TypeContratDto saveOrUpdate(TypeContratDto tcDto) {
        TypeContrat tc = MapperCommun.convert(tcDto, TypeContrat.class);
        tc = typeContratRepository.saveAndFlush(tc);
        return MapperCommun.convert(tc, TypeContratDto.class);
    }

    @Override
    public long countTypeContrat() {
        return typeContratRepository.count();
    }



}
