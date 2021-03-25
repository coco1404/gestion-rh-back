package fr.dawan.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.dawan.entities.Adresse;

@XmlRootElement(name = "entreprises")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntrepriseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

    @XmlElement
    private Adresse adresse;
    
    @XmlElement
    private int version;

    public EntrepriseDto() {
    }

    public EntrepriseDto(long id, String nom, Adresse adresse, int version) {
        this.id = id;
        this.nom = nom;
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
