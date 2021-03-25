package fr.dawan.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name = "postes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PosteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private long id;

    @XmlElement
    private TitrePosteDto titrePoste;

    @JsonIgnoreProperties("postes")
    private SalarieDto salarie;

    @XmlElement
    private TypeContratDto typeContrat;

    @XmlElement
    private Date dateDebut;

    @XmlElement
    private Date dateFin;

    @XmlElement
    private float volumeHoraire;

    @XmlElement
    private float volumeJournalier;

    @XmlElement
    private SalarieDto manager;

    @XmlElement
    private String fichierContrat;

    @XmlElement
    private EntrepriseDto lieuTravail;

    @XmlElement
    private List<CompetenceDto> competencesRequises;
    
    @XmlElement
    private int version;

    public PosteDto() {
    }

    public PosteDto(long id, TitrePosteDto titrePoste, SalarieDto salarie, TypeContratDto typeContrat, Date dateDebut,
            Date dateFin, float volumeHoraire, float volumeJournalier, SalarieDto manager, String fichierContrat,
            EntrepriseDto lieuTravail, List<CompetenceDto> competencesRequises, int version) {
        this.id = id;
        this.titrePoste = titrePoste;
        this.salarie = salarie;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.volumeHoraire = volumeHoraire;
        this.volumeJournalier = volumeJournalier;
        this.manager = manager;
        this.fichierContrat = fichierContrat;
        this.lieuTravail = lieuTravail;
        this.competencesRequises = competencesRequises;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TitrePosteDto getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(TitrePosteDto titrePoste) {
        this.titrePoste = titrePoste;
    }

    public SalarieDto getSalarie() {
        return salarie;
    }

    public void setSalarie(SalarieDto salarie) {
        this.salarie = salarie;
    }

    public TypeContratDto getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContratDto typeContrat) {
        this.typeContrat = typeContrat;
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

    public float getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(float volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public float getVolumeJournalier() {
        return volumeJournalier;
    }

    public void setVolumeJournalier(float volumeJournalier) {
        this.volumeJournalier = volumeJournalier;
    }

    public SalarieDto getManager() {
        return manager;
    }

    public void setManager(SalarieDto manager) {
        this.manager = manager;
    }

    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    public EntrepriseDto getLieuTravail() {
        return lieuTravail;
    }

    public void setLieuTravail(EntrepriseDto lieuTravail) {
        this.lieuTravail = lieuTravail;
    }

    public List<CompetenceDto> getCompetencesRequises() {
        return competencesRequises;
    }

    public void setCompetencesRequises(List<CompetenceDto> competencesRequises) {
        this.competencesRequises = competencesRequises;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
