package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "titreposte")
public class TitrePoste {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 255)
    private String titrePoste;
    
    @Version
    private int version;
    
    public TitrePoste() {}    
    public TitrePoste(long id, String titrePoste, int version) {
        super();
        this.id = id;
        this.titrePoste = titrePoste;
        this.version = version;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getTitrePoste() {
        return titrePoste;
    }
    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
