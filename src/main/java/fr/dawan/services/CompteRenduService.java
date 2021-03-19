package fr.dawan.services;

import java.util.List;

import fr.dawan.dto.CompteRenduDto;

public interface CompteRenduService {
    List<CompteRenduDto> getCompteRenduByIdEntretien(long idEntretien);//EntretienController
    List<CompteRenduDto> getCompteRenduByIdManagerEntretien(long idManagerEntretien);//EntretienController
    List<CompteRenduDto> getCompteRenduByIdSalarie(long idSalarie);//SalarieController
    CompteRenduDto saveOrUpdate(CompteRenduDto compteRenduDto);
    CompteRenduDto getCompteRenduById(long idCompteRendu);
    void delete(CompteRenduDto compteRenduDto);
    void deleteById(long idCompteRendu);

}
