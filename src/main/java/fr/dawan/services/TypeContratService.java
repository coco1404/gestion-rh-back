package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.TypeContratDto;

public interface TypeContratService {
    List<TypeContratDto> findAll();
    List<TypeContratDto> getAllTypeContracts(int page, int max);
    List<TypeContratDto> findByName(String type);
    TypeContratDto findById(long id);
    void deleteById(long id);
    TypeContratDto saveOrUpdate(TypeContratDto tcDto);
    
}
