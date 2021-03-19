package fr.dawan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.TypeContrat;

public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {

    @Query("FROM TypeContrat tc WHERE tc.type= :name")
    TypeContrat findByName(@Param("name")String type);
}
