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
    
    @XmlElement
    private String titre;

    /**
     * durée en heure
     */
    @XmlElement
    private float duree;

    @XmlElement
    private float prix;

    @XmlElement
    private DomaineDto domaine;
    
    @XmlElement
    private List<CompetenceDto> competences;
    
    @XmlElement
    private int version;

    public CreateFormationDto() {
    }

    public CreateFormationDto(long id, Date dateDebut, Date dateFin, String titre, float duree, float prix,
            DomaineDto domaine, List<CompetenceDto> competences, int version) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.titre = titre;
        this.duree = duree;
        this.prix = prix;
        this.domaine = domaine;
        this.competences = competences;
        this.version = version;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
