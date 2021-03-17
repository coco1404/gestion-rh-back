package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "compterendu")
public class CompteRendu { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 255)
    private String compteRendu;
    
    @Version
    private int version;
    
    public CompteRendu() {}
    public CompteRendu(long id, String compteRendu, int version) {
        super();
        this.id = id;
        this.compteRendu = compteRendu;
        this.version = version;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getCompteRendu() {
        return compteRendu;
    }
    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
