package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Salarie;

public interface SalarieRepository extends JpaRepository<Salarie, Long> {

    @Query("FROM Salarie salarie WHERE salarie.adresse.id = :id")
    List<Salarie> findAllSalariesByAdresse(@Param("id")long idAdresse);
    
    @Query("FROM Salarie salarie WHERE salarie.domaine.id = :id")
    List<Salarie> findAllSalariesByDomaine(@Param("id")long idDomaine);
    
    @Query("FROM Salarie salarie WHERE salarie.entreprise.id = :id")
    List<Salarie> findAllSalariesByEntreprise(@Param("id")long idEntreprise);
    
//    @Query("FROM Salarie salarie"
//            + " JOIN Poste poste ON salarie.id = poste.salarie.id"
//            + " WHERE poste.titrePoste.id = :id")
    @Query("SELECT p.salarie FROM Poste p WHERE p.titrePoste.id =:id")
    List<Salarie> findAllSalariesByTitrePoste(@Param("id") long idTitrePoste);
    
    @Query("FROM Salarie s JOIN FETCH s.formations f WHERE f.id = :idFormation")
    List<Salarie> getSalarieByIdFormation(@Param("idFormation") long idFormation);
    
}