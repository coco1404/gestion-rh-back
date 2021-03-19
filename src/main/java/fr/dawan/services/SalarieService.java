package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;

public interface SalarieService {
    List<SalarieDto> findAll();
    List<SalarieDto> getAllSalaries(int page, int max);
    List<SalarieDto> findAllSalariesByAdresse(long id);
    List<SalarieDto> findAllSalariesByDomaine(long id);
    List<SalarieDto> findAllSalariesByEntreprise(long id);
    List<SalarieDto> findAllSalariesByPoste(long id);
    SalarieDto findById(long id);
    void deleteById(long id);
    SalarieDto saveOrUpdate(SalarieDto salarieDto);
    List<FormationDto> findFormationBySalarie(long id);
    List<RoleDto> findRoleBySalarie(long id);
    List<CompetenceDto> findCompetenceBySalarie(long id);
}
