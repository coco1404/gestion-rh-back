package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.TitrePosteDto;

public interface TitrePosteService {
    List<TitrePosteDto> findAll();
    List<TitrePosteDto> getAllTitresPostes(int page, int max);
    TitrePosteDto findByName(String name);
    TitrePosteDto findById(long id);
    void deleteById(long id);
    TitrePosteDto saveOrUpdate(TitrePosteDto tpDto);
}
