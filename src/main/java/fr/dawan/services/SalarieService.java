package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.CompetenceDto;
import fr.dawan.dto.FormationDto;
import fr.dawan.dto.RoleDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.dto.SalarieListeDto;

public interface SalarieService {
    List<SalarieDto> findAll();
    List<SalarieDto> getAllSalaries(int page, int max);
    List<SalarieDto> findAllSalariesByAdresse(long id);
    List<SalarieDto> findAllSalariesByDomaine(long id);
    List<SalarieDto> findAllSalariesByEntreprise(long id);
    List<SalarieDto> findAllSalariesByTitrePoste(long id);
    SalarieDto findById(long id);
    SalarieDto findByEmail(String email);
    SalarieDto saveOrUpdate(SalarieDto salarieDto);
    SalarieDto updateWithoutPassword(SalarieDto salarieDto);
    List<FormationDto> findFormationBySalarie(long id);
    List<RoleDto> findRoleBySalarie(long id);
    List<CompetenceDto> findCompetenceBySalarie(long id);
    List<SalarieListeDto> getAllSalariesWithPosteByPage(int page, int size);
    long countSalarie();
}
