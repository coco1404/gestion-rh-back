package fr.dawan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Domaine;

public interface DomaineRepository extends JpaRepository<Domaine, Long>{
    @Query("FROM Domaine d WHERE d.titre= :name")
    Domaine findByName(@Param("name")String name);
}
