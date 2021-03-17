package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    public enum roles {
        SALARIE, ADMIN, RH, MANAGER
    }
    
    @Column(nullable = false, length = 150)
    @Enumerated(EnumType.STRING)
    private roles role;
    
    @Version
    private int version;
    
    public Role() {}
    public Role(long id, roles role, int version) {
        super();
        this.id = id;
        this.role = role;
        this.version = version;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public roles getRole() {
        return role;
    }
    public void setRole(roles role) {
        this.role = role;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
