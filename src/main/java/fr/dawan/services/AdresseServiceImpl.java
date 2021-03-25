package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.AdresseDto;
import fr.dawan.entities.Adresse;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.AdresseRepository;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    @Override
    public List<AdresseDto> findAll(String filtre, String sort) {
        
        Sort params = null;
        if(filtre == null) {
            filtre = "id";
        }
        
        if((sort=="ASC" || sort == null))
            params = Sort.by(filtre).ascending();
        else
            params = Sort.by(filtre).descending();
        
        List<Adresse> lst = adresseRepository.findAll(params);
        
        List<AdresseDto> result = new ArrayList<AdresseDto>();
        for(Adresse a : lst) {
         result.add(MapperCommun.convert(a, AdresseDto.class));
        }
        return result;
    }

    @Override
    public List<AdresseDto> getAllAdresses(int page, int max) {
        List<Adresse> lst = adresseRepository.findAll(PageRequest.of(page, max)).get().collect(Collectors.toList());
        List<AdresseDto> result = new ArrayList<AdresseDto>();
        for (Adresse a : lst) {
            result.add(MapperCommun.convert(a, AdresseDto.class));
        }
        return result;
    }

    @Override
    public AdresseDto getById(long id) {
        Optional<Adresse> adresse = adresseRepository.findById(id);
        if (adresse.isPresent()) {
            return MapperCommun.convert(adresse.get(), AdresseDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        adresseRepository.deleteById(id);

    }

    @Override
    public AdresseDto saveOrUpdate(AdresseDto aDto) {
        Adresse adr = MapperCommun.convert(aDto, Adresse.class);
        adr = adresseRepository.saveAndFlush(adr);
        return MapperCommun.convert(adr, AdresseDto.class);
    }

}
