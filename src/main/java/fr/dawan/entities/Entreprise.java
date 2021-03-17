package fr.dawan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "companie")
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false, length = 255)
    private String nom; 

    @Column(nullable = false, length = 255)
    private String implantation; // voir si c'est bon
    
    @ManyToOne
    private Adresse adresse;
    
    @Version
    private int version;
    
    public Entreprise() {}
    public Entreprise(long id, String nom, String implantation, Adresse adresse, int version) {
        super();
        this.id = id;
        this.nom = nom;
        this.implantation = implantation;
        this.adresse = adresse;
        this.version = version;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getImplantation() {
        return implantation;
    }
    public void setImplantation(String implantation) {
        this.implantation = implantation;
    }
    
    public Adresse getAdresse() {
        return adresse;
    }
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
