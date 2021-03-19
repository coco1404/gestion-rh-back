package fr.dawan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.TitrePoste;

public interface TitrePosteRepository extends JpaRepository<TitrePoste, Long> {

    @Query("FROM TitrePoste tp WHERE tp.intitule= :name")
    TitrePoste findByName(@Param("name")String name);
}
