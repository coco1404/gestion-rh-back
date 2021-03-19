package fr.dawan.services;

import java.util.Date;
import java.util.List;

import fr.dawan.dto.PosteDto;

public interface PosteService {
    List<PosteDto> getAllPoste(int page, int size);
    List<PosteDto> getPosteByTypeContrat(long idTypeContrat);
    List<PosteDto> getPosteByManager(long idManager);
    List<PosteDto> getPosteByLieuTravail(long idLieuTravail);
    List<PosteDto> recherchePoste(String recherche);
    List<PosteDto> recherchePoste(Date dateDebut, Date dateFin);
    PosteDto saveOrUpdate(PosteDto posteDto); 
    void delete(PosteDto posteDto);
    void deleteById(long idPoste);
}
