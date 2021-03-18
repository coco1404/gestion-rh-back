package fr.dawan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.entities.Salarie;

public interface SalarieRepository extends JpaRepository<Salarie, Long> {

}
