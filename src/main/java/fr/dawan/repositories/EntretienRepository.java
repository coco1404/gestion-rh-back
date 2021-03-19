package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Entretien;

public interface EntretienRepository extends JpaRepository<Entretien, Long> {

    @Query("FROM Entretien entretien WHERE entretien.managerEntretien.id = :id")
    List<Entretien> getByManager(@Param("id")long id);
    
    @Query("FROM Entretien entretien WHERE entretien.salarie.id = :id")
    List<Entretien> getBySalarie(@Param("id")long id);
}
