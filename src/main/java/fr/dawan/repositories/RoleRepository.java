package fr.dawan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("FROM Role role WHERE role.titre= :name")
    Role findByName(@Param("name")String name);
    
    @Query("FROM Role role JOIN role.salaries rs WHERE rs.id= :id")
    List<Role> findRoleBySalarie(@Param("id")long id);
    
}
