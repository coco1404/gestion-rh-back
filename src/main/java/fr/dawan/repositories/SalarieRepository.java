package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
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
    
    @Query("FROM Salarie s WHERE s.email = :email")
    Salarie findByEmail(@Param("email") String email);
    
    
    /*@Query("SELECT DISTINCT s, "
            + " ( "
                + " SELECT "
                    + " CASE "
                        + " WHEN p2.dateFin IS NULL THEN 'POSTE' "
                        + " WHEN p2.dateFin > CURRENT_DATE() THEN 'POSTE' "
                        + " ELSE NULL"
                    + " END as p"
                + " FROM s.postes p2 WHERE p2.salarie_id = s.id ORDER BY p2.id DESC LIMIT 1 "
            + " ) as poste FROM Salarie s HAVING poste IS NULL")*/
    @Query(value = "SELECT DISTINCT s.*, ( SELECT CASE WHEN p2.date_fin IS NULL THEN 'POSTE' WHEN p2.date_fin > CURRENT_DATE() THEN 'POSTE' ELSE NULL END as p FROM postes p2 WHERE p2.salarie_id = s.id ORDER BY p2.id DESC LIMIT 1 ) as poste FROM salaries s HAVING poste IS NULL ",nativeQuery = true)
    List<Salarie> findAllWithoutPoste();
    
    @Query(value = "SELECT DISTINCT s.*, ( SELECT CASE WHEN p2.date_fin IS NULL THEN 'POSTE' WHEN p2.date_fin > CURRENT_DATE() THEN 'POSTE' ELSE NULL END as p FROM postes p2 WHERE p2.salarie_id = s.id ORDER BY p2.id DESC LIMIT 1 ) as poste FROM salaries s LEFT JOIN salarie_competence sc on sc.salarie_id = s.id WHERE s.domaine_id = :domaine AND sc.competence_id IN (:competence) GROUP BY s.id HAVING poste IS NULL AND COUNT(*) = :nbComp ORDER BY s.nom ASC, s.prenom ASC",nativeQuery = true)
    List<Salarie> findAllWithoutPosteByDomaineAndCompetence(@Param("domaine") long domaine, @Param("competence") List<Long> competence, @Param("nbComp") long nbComp);
    
    @Query("SELECT DISTINCT s FROM Salarie s LEFT JOIN s.domaine d LEFT JOIN s.competences c WHERE d.id = :domaine AND c.id IN (:competence) GROUP BY s.id HAVING COUNT(*) = :nbComp")
    List<Salarie> findAllByDomaineAndCompetence(@Param("domaine") long domaine, @Param("competence") List<Long> competence, @Param("nbComp") long nbComp, Sort sort);
    
}