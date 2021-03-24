package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.DomaineDto;

public interface DomaineService {
    List<DomaineDto> findAll();
    List<DomaineDto> getAllDomaines(int page, int max);
    DomaineDto getById(long id);
    List<DomaineDto> findByName(String name);
    void deleteById(long id);
    DomaineDto saveOrUpdate(DomaineDto dDto);

}
