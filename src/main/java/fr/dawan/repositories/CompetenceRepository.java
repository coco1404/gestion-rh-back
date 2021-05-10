package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    @Query("FROM Poste p JOIN FETCH p.competencesRequises WHERE p.id = :idPoste")
    List<Competence> getComptenceByIdPoste(@Param("idPoste") long idPoste);
    
    @Query("FROM Competence c JOIN FETCH c.salaries cs WHERE cs.id = :id")
    List<Competence> findCompetenceBySalarie(@Param("id") long idSalarie);
    
    @Query("FROM Competence c JOIN FETCH c.domaines cd WHERE cd.id = :idDomaine")
    List<Competence> findCompetenceByIdDomaine(@Param("idDomaine") long idDomaine);
}
