package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    @Query(" SELECT p.competencesRequises "
            + " FROM Poste p "
            + " WHERE p.id = :idPoste ")
    List<Competence> getComptenceByIdPoste(@Param("idPoste") long idPoste);
}
