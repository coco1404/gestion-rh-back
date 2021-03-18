package fr.dawan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
