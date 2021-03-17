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
@Table(name = "domaine")
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    public enum domaines {
        INFORMATIQUE, SECRETARIA, COMMERCIAL
    }
    
    @Column(nullable = false, length = 150)
    @Enumerated(EnumType.STRING)
    private domaines domaine;
    
    @Version
    private int version;
    public Domaine() {}
    public Domaine(long id, domaines domaine, int version) {
        super();
        this.id = id;
        this.domaine = domaine;
        this.version = version;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public domaines getDomaine() {
        return domaine;
    }
    public void setDomaine(domaines domaine) {
        this.domaine = domaine;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
