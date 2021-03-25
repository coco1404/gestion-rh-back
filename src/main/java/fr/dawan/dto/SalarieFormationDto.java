package fr.dawan.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "salaries-formation")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalarieFormationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String email;

    @XmlElement
    private DomaineDto domaine;

    @XmlElement
    private List<CompetenceDto> competences;

    @XmlElement
    private List<FormationDto> formations;
    
    @XmlElement
    private int version;

    public SalarieFormationDto() {
    }

    public SalarieFormationDto(long id, String nom, String prenom, String email, DomaineDto domaine,
            List<CompetenceDto> competences, List<FormationDto> formations, int version) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.domaine = domaine;
        this.competences = competences;
        this.formations = formations;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DomaineDto getDomaine() {
        return domaine;
    }

    public void setDomaine(DomaineDto domaine) {
        this.domaine = domaine;
    }

    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }

    public List<FormationDto> getFormations() {
        return formations;
    }

    public void setFormations(List<FormationDto> formations) {
        this.formations = formations;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
