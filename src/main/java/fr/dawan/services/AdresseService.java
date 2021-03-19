package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.AdresseDto;

public interface AdresseService {  
    List<AdresseDto> findAll();
    List<AdresseDto> getAllAdresses(int page, int max);
    AdresseDto getById(long id);
    void deleteById(long id);
    AdresseDto saveOrUpdate(AdresseDto aDto);
}
