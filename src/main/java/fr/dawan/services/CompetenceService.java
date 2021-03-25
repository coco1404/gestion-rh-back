package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.CompetenceDto;

public interface CompetenceService {
    List<CompetenceDto> getAllComptence();
    List<CompetenceDto> getComptenceByIdPoste(long idPoste);//PosteController
    CompetenceDto saveOrUpdate(CompetenceDto competenceDto); 
    void delete(CompetenceDto comptenceDto);
    void deleteById(long idCompetence);
    long countCompetence();
}
