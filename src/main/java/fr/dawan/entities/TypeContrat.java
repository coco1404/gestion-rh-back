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
@Table(name = "typecontrat")
public class TypeContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    public enum ContratType {
        CDI, CDD, ALTERNANCE, APPRENTISSAGE, INTERIMAIRE
    }
    
    @Column(nullable = false, length = 150)
    @Enumerated(EnumType.STRING)
    private ContratType contratType;
    
    @Version
    private int version;
    
    public TypeContrat() {}
    public TypeContrat(long id, ContratType contratType, int version) {
        super();
        this.id = id;
        this.contratType = contratType;
        this.version = version;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public ContratType getContratType() {
        return contratType;
    }
    public void setContratType(ContratType contratType) {
        this.contratType = contratType;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    } 
}
