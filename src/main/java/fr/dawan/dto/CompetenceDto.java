package fr.dawan.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competences")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompetenceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private String nom;

//    @XmlElement
//    private List<SalarieDto> salaries;
//
//    @XmlElement
//    private List<FormationDto> formations;
//
//    @XmlElement
//    private List<PosteDto> postes;

    public CompetenceDto() {
    }

    
    public CompetenceDto(long id, String nom) {
        this.id = id;
        this.nom = nom;
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

//    public List<SalarieDto> getSalaries() {
//        return salaries;
//    }
//
//    public void setSalaries(List<SalarieDto> salaries) {
//        this.salaries = salaries;
//    }
//
//    public List<FormationDto> getFormations() {
//        return formations;
//    }
//
//    public void setFormations(List<FormationDto> formations) {
//        this.formations = formations;
//    }
//
//    public List<PosteDto> getPostes() {
//        return postes;
//    }
//
//    public void setPostes(List<PosteDto> postes) {
//        this.postes = postes;
//    }
}
