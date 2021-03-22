package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.CompteRendu;

public interface CompteRenduRepository extends JpaRepository<CompteRendu, Long> {
    @Query("SELECT e.compteRendu FROM Entretien e where e.id = :idEntretien ")
    List<CompteRendu> getCompteRenduByIdEntretien(@Param("idEntretien") long idEntretien);
    
    @Query("SELECT e.compteRendu FROM Entretien e where e.managerEntretien.id = :idManagerEntretien ")
    List<CompteRendu> getCompteRenduByIdManagerEntretien(@Param("idManagerEntretien") long idManagerEntretien);
    
    @Query("SELECT e.compteRendu FROM Entretien e where e.salarie.id= :idSalarie ")
    List<CompteRendu> getCompteRenduByIdSalarie(@Param("idSalarie") long idSalarie);
}
