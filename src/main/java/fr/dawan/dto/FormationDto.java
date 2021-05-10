package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "formations")
@XmlAccessorType(XmlAccessType.FIELD)
public class FormationDto implements Serializable {

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
    private int version;

    @XmlElement
    private DomaineDto domaine;
    
    @XmlElement
    private List<CompetenceDto> competences;

    public FormationDto() {
    }

    public FormationDto(long id, Date dateDebut, Date dateFin,String titre, float duree, float prix, int version, DomaineDto domaine,List<CompetenceDto> competences) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.titre = titre;
        this.duree = duree;
        this.prix = prix;
        this.version = version;
        this.domaine = domaine;
        this.competences = competences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public DomaineDto getDomaine() {
        return domaine;
    }

    public void setDomaine(DomaineDto domaine) {
        this.domaine = domaine;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }

    
}
