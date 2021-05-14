package fr.dawan.services;

import java.util.Date;
import java.util.List;

import fr.dawan.dto.PosteDto;

public interface PosteService {
    List<PosteDto> getAllPosteByPage(int page, int size);
    List<PosteDto> getAllPoste();
    PosteDto getPosteById(long id);
    List<PosteDto> getPosteByTypeContrat(long idTypeContrat);
    List<PosteDto> getPosteByManager(long idManager);
    List<PosteDto> getPosteByLieuTravail(long idLieuTravail);
    List<PosteDto> recherchePoste(String recherche);
    List<PosteDto> recherchePoste(Date dateDebut, Date dateFin);
    PosteDto saveOrUpdate(PosteDto posteDto); 
    void cloturerPoste(long id);
    void updateContrat(String name, long idPoste);
    void delete(PosteDto posteDto);
    void deleteById(long idPoste);
    long countPoste();
}
