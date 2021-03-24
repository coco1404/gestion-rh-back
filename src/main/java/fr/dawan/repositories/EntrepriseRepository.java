package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{
    
    @Query("FROM Entreprise e WHERE LOWER(e.nom) LIKE %:name%")
    List<Entreprise> findByName(@Param("name")String name);
    
    @Query("FROM Entreprise e "
            + "WHERE e.adresse.id= :idAdresse")
    Entreprise findByAdresseId(@Param("idAdresse")long id);
}
