package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.EntrepriseDto;

public interface EntrepriseService {
    List<EntrepriseDto> findAll();
    List<EntrepriseDto> getAllEntreprises(int page, int max);
    EntrepriseDto findById(long id);
    EntrepriseDto findByName(String name);
    EntrepriseDto findByAdresseId(long id);
    void deleteById(long id);
    EntrepriseDto saveOrUpdate(EntrepriseDto rDto);
}
