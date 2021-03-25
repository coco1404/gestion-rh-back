package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.EntretienDto;

public interface EntretienService {
    List<EntretienDto> findAll();
    List<EntretienDto> getAllEntretien(int page, int max);
    List<EntretienDto> getByManager(long id);
    List<EntretienDto> getBySalarie(long id);
    EntretienDto findById(long id);
    void deleteById(long id);
    EntretienDto saveOrUpdate(EntretienDto entretienDto);
    long countEntretien();
}
