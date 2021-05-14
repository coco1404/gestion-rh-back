package fr.dawan.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Poste;

public interface PosteRepository extends JpaRepository<Poste, Long>{
    @Query(" FROM Poste p "
            + " WHERE p.typeContrat.id = :idTypeContrat ")
    List<Poste> getPosteByTypeContrat(@Param("idTypeContrat") long idTypeContrat);
    
    @Query(" FROM Poste p "
            + " WHERE p.manager.id = :idManager ")
    List<Poste> getPosteByManager(@Param("idManager") long idManager);
    
    @Query(" FROM Poste p "
            + " WHERE p.lieuTravail.id = :idLieuTravail ")
    List<Poste> getPosteByLieuTravail(@Param("idLieuTravail") long idLieuTravail);
    
    @Query(" FROM Poste p "
            + " WHERE LOWER(p.titrePoste.intitule) LIKE %:recherche% ")
    List<Poste> recherchePoste(@Param("recherche") String recherche);
    
    @Query(" FROM Poste p "
            + " WHERE p.dateDebut BETWEEN :dateDebut and :dateFin "
            + " OR p.dateFin BETWEEN :dateDebut and :dateFin ")
    List<Poste> recherchePoste(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    
    /*@Query(" FROM Poste p "
            + " WHERE (p.dateFin > CURRENT_DATE OR p.dateFin IS NULL)"
            + " AND p.salarie.id IS NOT NULL ")*/
    @Query(" FROM Poste p "
            + " ORDER BY p.salarie.id ASC, p.dateFin DESC ")
    List<Poste> getAllSalariesWithPosteByPage(PageRequest pageRequest);
    
    @Modifying
    @Query(" UPDATE Poste p set p.fichierContrat = :name where p.id = :idPoste ")
    void updateContrat(@Param("name") String name, @Param("idPoste") long idPoste);
    
    @Modifying
    @Query(" UPDATE Poste p set p.dateFin = CURRENT_DATE() where p.id = :id ")
    void cloturerPoste(@Param("id") long id);
}
