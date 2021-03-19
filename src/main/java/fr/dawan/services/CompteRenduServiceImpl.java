package fr.dawan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.CompteRenduDto;
import fr.dawan.entities.CompteRendu;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.CompteRenduRepository;

@Service
@Transactional
public class CompteRenduServiceImpl implements CompteRenduService{
    
    @Autowired
    CompteRenduRepository compteRenduRepository ; 
    
    @Override
    public List<CompteRenduDto> getCompteRenduByIdEntretien(long idEntretien) {
        List<CompteRendu> lst = compteRenduRepository.getCompteRenduByIdEntretien(idEntretien);
        List<CompteRenduDto> result = new ArrayList<CompteRenduDto>();
        for (CompteRendu c : lst) {
            result.add(MapperCommun.convert(c, CompteRenduDto.class));
        }
        return result;
    }

    @Override
    public List<CompteRenduDto> getCompteRenduByIdManagerEntretien(long idManagerEntretien) {
        List<CompteRendu> lst = compteRenduRepository.getCompteRenduByIdManagerEntretien(idManagerEntretien);
        List<CompteRenduDto> result = new ArrayList<CompteRenduDto>();
        for (CompteRendu c : lst) {
            result.add(MapperCommun.convert(c, CompteRenduDto.class));
        }
        return result;
    }

    @Override
    public List<CompteRenduDto> getCompteRenduByIdSalarie(long idSalarie) {
        List<CompteRendu> lst = compteRenduRepository.getCompteRenduByIdSalarie(idSalarie);
        List<CompteRenduDto> result = new ArrayList<CompteRenduDto>();
        for (CompteRendu c : lst) {
            result.add(MapperCommun.convert(c, CompteRenduDto.class));
        }
        return result;
    }

    @Override
    public CompteRenduDto saveOrUpdate(CompteRenduDto compteRenduDto) {
        CompteRendu c = MapperCommun.convert(compteRenduDto, CompteRendu.class);
        c = compteRenduRepository.saveAndFlush(c);
        return MapperCommun.convert(c, CompteRenduDto.class);
    }

    @Override
    public void delete(CompteRenduDto compteRenduDto) {
        CompteRendu c = MapperCommun.convert(compteRenduDto, CompteRendu.class);
        compteRenduRepository.delete(c);
    }

    @Override
    public CompteRenduDto getCompteRenduById(long idCompteRendu) {
        Optional<CompteRendu> c = compteRenduRepository.findById(idCompteRendu);
        if (c.isPresent())
            return MapperCommun.convert(c.get(), CompteRenduDto.class);

        return null;
    }

    @Override
    public void deleteById(long idCompteRendu) {
        compteRenduRepository.deleteById(idCompteRendu);
    }

}
