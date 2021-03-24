package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.TypeContrat;

public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {

    @Query("FROM TypeContrat tc WHERE LOWER(tc.type)  LIKE %:name%")
    List<TypeContrat> findByName(@Param("name")String type);
}
