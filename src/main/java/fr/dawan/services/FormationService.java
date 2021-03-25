package fr.dawan.services;

import java.util.Date;
import java.util.List;

import fr.dawan.dto.CreateFormationDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.SalarieDto;

public interface FormationService {
    List<FormationDto> getAllFormation(int page, int size);
    List<FormationDto> getAllFormationEnCours(int page, int size);
    List<FormationDto> getAllFormationNonCommence(int page, int size);
    List<FormationDto> getAllFormationByIdCompetence(long idCompetence);
    List<FormationDto> getAllFormationByDate(Date date);
    List<FormationDto> getAllFormationByPeriode(Date dateDebut, Date dateFin);
    List<SalarieDto> getSalarieByIdFormation(long idFormation);
    void deleteById(long id);
    CreateFormationDto saveOrUpdate(CreateFormationDto formationDto); 
    long countFormation();
}
