package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Value;

//pb de génération des tables avec el @manytoone : poste, typeContrat, manager

@Entity
@Table(name = "postes")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TitrePoste titrePoste;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Salarie salarie;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TypeContrat typeContrat;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(precision = 2)
    @Value("${some.key:0}")
    private float volumeHoraire;

    @Column(precision = 2)
    @Value("${some.key:0}")
    private float volumeJournalier;

    @ManyToOne(optional = true)
    private Salarie manager;

    @Column(nullable = false, length = 255)
    private String fichierContrat;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Entreprise lieuTravail;

    @ManyToMany
    @JoinTable(
        name="poste_competence",
        joinColumns=
        @JoinColumn( name="poste_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="competence_id", referencedColumnName="id"))
    private List<Competence> competencesRequises;

    @Version
    private int version;

    public Poste() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TitrePoste getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(TitrePoste titrePoste) {
        this.titrePoste = titrePoste;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
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

    public Salarie getManager() {
        return manager;
    }

    public void setManager(Salarie manager) {
        this.manager = manager;
    }

    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    public Entreprise getLieuTravail() {
        return lieuTravail;
    }

    public void setLieuTravail(Entreprise lieuTravail) {
        this.lieuTravail = lieuTravail;
    }

    public List<Competence> getCompetencesRequises() {
        return competencesRequises;
    }

    public void setCompetencesRequises(List<Competence> competencesRequises) {
        this.competencesRequises = competencesRequises;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
