package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "createFormation")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateFormationDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private Date dateDebut;

    @XmlElement
    private Date dateFin;

    /**
     * durée en heure
     */
    @XmlElement
    private float duree;

    @XmlElement
    private float prix;

    @XmlElement
    private List<SalarieDto> salaries;

    @XmlElement
    private List<CompetenceDto> competences;

    public CreateFormationDto() {
    }

    public CreateFormationDto(long id, Date dateDebut, Date dateFin, float duree, float prix, List<SalarieDto> salaries,
            List<CompetenceDto> competences) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.duree = duree;
        this.prix = prix;
        this.salaries = salaries;
        this.competences = competences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public List<SalarieDto> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<SalarieDto> salaries) {
        this.salaries = salaries;
    }

    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }
}
