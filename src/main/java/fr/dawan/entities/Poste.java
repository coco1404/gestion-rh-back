package fr.dawan.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

//pb de génération des tables avec el @manytoone : poste, typeContrat, manager

@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private TitrePoste titrePoste;

    @ManyToOne
    private Salarie salarie;

    @ManyToOne
    private TypeContrat typeContrat;

    @Column(nullable = false, length = 255)
    private Date dateDebut;

    @Column(length = 255)
    private Date dateFin;

    @Column(length = 255)
    private float volumeHoraire;

    @Column(length = 255)
    private float volumeJournalier;

    @ManyToOne
    private Salarie manager;

    @Column(nullable = false, length = 255)
    private String pj;

    @ManyToOne
    private Entreprise lieuTravail;
    
    @ManyToMany
    private List<Competence> competenceRequise;
    
    @Version
    private int version;
    
    public Poste() {
    }
    public Poste(long id, TitrePoste titrePoste, Salarie salarie, TypeContrat typeContrat, Date dateDebut, Date dateFin,
            float volumeHoraire, float volumeJournalier, Salarie manager, String pj, Entreprise lieuTravail,
            List<Competence> competenceRequise, int version) {
        super();
        this.id = id;
        this.titrePoste = titrePoste;
        this.salarie = salarie;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.volumeHoraire = volumeHoraire;
        this.volumeJournalier = volumeJournalier;
        this.manager = manager;
        this.pj = pj;
        this.lieuTravail = lieuTravail;
        this.competenceRequise = competenceRequise;
        this.version = version;
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

    public String getPj() {
        return pj;
    }
    public void setPj(String pj) {
        this.pj = pj;
    }
    
    public Entreprise getLieuTravail() {
        return lieuTravail;
    }
    public void setLieuTravail(Entreprise lieuTravail) {
        this.lieuTravail = lieuTravail;
    }
    
    public List<Competence> getCompetenceRequise() {
        return competenceRequise;
    }
    public void setCompetenceRequise(List<Competence> competenceRequise) {
        this.competenceRequise = competenceRequise;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }    
}
