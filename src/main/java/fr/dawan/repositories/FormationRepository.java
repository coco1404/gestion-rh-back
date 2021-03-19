package fr.dawan.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long>{
    
    @Query(" FROM Formation f "
            + " WHERE f.dateDebut < CURRENT_DATE "
            + " AND f.dateFin > CURRENT_DATE ")
    List<Formation> getAllFormationEnCours(PageRequest pageRequest);
    
    @Query(" FROM Formation f "
            + " WHERE f.dateDebut > CURRENT_DATE ")
    List<Formation> getAllFormationNonCommence(PageRequest pageRequest);
    
    @Query(" FROM Formation f "
            + " JOIN f.competences c "
            + " WHERE c.id = :idCompetence ")
    List<Formation> getAllFormationByIdCompetence(@Param("idCompetence") long idCompetence);
    
    @Query(" FROM Formation f "
            + " WHERE f.dateDebut < :date "
            + " AND f.dateFin > :date ")
    List<Formation> getAllFormationByDate(@Param("date") Date date);
    
    @Query(" FROM Formation f "
            + " WHERE f.dateDebut < :dateDebut "
            + " AND f.dateFin > :dateFin ")
    List<Formation> getAllFormationByPeriode(@Param("date") Date dateDebut, @Param("date") Date dateFin);
}
